package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import io.github.wulkanowy.data.repositories.StudentRepository
import io.github.wulkanowy.ui.base.BasePresenter
import io.github.wulkanowy.ui.base.ErrorHandler
import javax.inject.Inject

class MenuOrderPresenter @Inject constructor(
    studentRepository: StudentRepository,
    errorHandler: ErrorHandler
) : BasePresenter<MenuOrderView>(errorHandler, studentRepository) {
}
