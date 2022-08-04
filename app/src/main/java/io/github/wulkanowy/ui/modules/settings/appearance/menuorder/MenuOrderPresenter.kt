package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import io.github.wulkanowy.data.repositories.StudentRepository
import io.github.wulkanowy.ui.base.BasePresenter
import io.github.wulkanowy.ui.base.ErrorHandler
import timber.log.Timber
import javax.inject.Inject

class MenuOrderPresenter @Inject constructor(
    studentRepository: StudentRepository,
    errorHandler: ErrorHandler
) : BasePresenter<MenuOrderView>(errorHandler, studentRepository) {

    override fun onAttachView(view: MenuOrderView) {
        super.onAttachView(view)
        view.initView()
        Timber.i("Menu order view was initialized")
        loadData()
    }

    private fun loadData() {
        view?.updateData(
            listOf(
                MenuItem.GradeMenuItem(1),
                MenuItem.StartMenuItem(0),
                MenuItem.AttendanceMenuItem(2),
                MenuItem.TimetableMenuItem(3)
            ).sortedBy { it.order }
        )
    }
}
