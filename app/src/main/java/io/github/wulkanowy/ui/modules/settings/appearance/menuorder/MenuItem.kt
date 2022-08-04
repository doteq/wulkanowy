package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import io.github.wulkanowy.R

sealed class MenuItem(
    open val order: Int,
    open val icon: Int,
    open val title: Int
) {

    data class StartMenuItem(override val order: Int) :
        MenuItem(order, R.drawable.ic_main_dashboard, R.string.dashboard_title)

    data class GradeMenuItem(override val order: Int) :
        MenuItem(order, R.drawable.ic_main_grade, R.string.grade_title)

    data class AttendanceMenuItem(override val order: Int) :
        MenuItem(order, R.drawable.ic_main_attendance, R.string.attendance_title)

    data class TimetableMenuItem(override val order: Int) :
        MenuItem(order, R.drawable.ic_main_timetable, R.string.timetable_title)
}
