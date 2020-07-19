package io.github.wulkanowy.ui.base

import io.github.wulkanowy.data.Status
import io.github.wulkanowy.data.repositories.student.StudentRepository
import io.github.wulkanowy.utils.SchedulersProvider
import io.github.wulkanowy.utils.flowWithResource
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

open class BasePresenter<T : BaseView>(
    protected val errorHandler: ErrorHandler,
    protected val studentRepository: StudentRepository,
    protected val schedulers: SchedulersProvider
) : CoroutineScope {

    private var job: Job = Job()

    private val jobs = mutableMapOf<String, Job>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    @Deprecated("Use flow instead :)")
    val disposable = CompositeDisposable()

    var view: T? = null

    open fun onAttachView(view: T) {
        job = Job()
        this.view = view
        errorHandler.apply {
            showErrorMessage = view::showError
            onSessionExpired = view::showExpiredDialog
            onNoCurrentStudent = view::openClearLoginView
        }
    }

    fun onExpiredLoginSelected() {
        flowWithResource {
            val student = studentRepository.getCurrentStudent(false)
            studentRepository.logoutStudent(student)

            val students = studentRepository.getSavedStudents(false)
            if (students.isNotEmpty()) {
                Timber.i("Switching current student")
                studentRepository.switchStudent(students[0])
            }
        }.onEach {
            when (it.status) {
                Status.LOADING -> Timber.i("Attempt to switch the student after the session expires")
                Status.SUCCESS -> {
                    Timber.i("Switch student result: Open login view")
                    view?.openClearLoginView()
                }
                Status.ERROR -> {
                    Timber.i("Switch student result: An exception occurred")
                    errorHandler.dispatch(it.error!!)
                }
            }
        }.launch("expired")
    }

    fun <T> Flow<T>.launch(individualJobTag: String = "load"): Job {
        jobs[individualJobTag]?.cancel()
        val job = launchIn(this@BasePresenter)
        jobs[individualJobTag] = job
        Timber.d("Job $individualJobTag launched in ${this@BasePresenter.javaClass.simpleName}: $job")
        return job
    }

    fun cancelJobs(vararg names: String) {
        names.forEach {
            jobs[it]?.cancel()
        }
    }

    open fun onDetachView() {
        view = null
        disposable.clear()
        job.cancel()
        errorHandler.clear()
    }
}
