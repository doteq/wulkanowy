package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import io.github.wulkanowy.R

sealed class MenuItem(
    open val order: Int,
    open val icon: Int,
    open val title: Int
) {

    data class StartMenuItem(override val order: Int = 0) :
        MenuItem(order, R.drawable.ic_main_dashboard, R.string.dashboard_title)

    data class GradeMenuItem(override val order: Int = 1) :
        MenuItem(order, R.drawable.ic_main_grade, R.string.grade_title)

    data class AttendanceMenuItem(override val order: Int = 2) :
        MenuItem(order, R.drawable.ic_main_attendance, R.string.attendance_title)

    data class TimetableMenuItem(override val order: Int = 3) :
        MenuItem(order, R.drawable.ic_main_timetable, R.string.timetable_title)

    data class MessageMenuItem(override val order: Int = 4) :
        MenuItem(order, R.drawable.ic_more_messages, R.string.message_title)

    data class ExamsMenuItem(override val order: Int = 5) :
        MenuItem(order, R.drawable.ic_main_exam, R.string.exam_title)

    data class HomeworkMenuItem(override val order: Int = 6) :
        MenuItem(order, R.drawable.ic_more_homework, R.string.homework_title)

    data class NoteMenuItem(override val order: Int = 7) :
        MenuItem(order, R.drawable.ic_more_note, R.string.note_title)

    data class LuckyNumberMenuItem(override val order: Int = 8) :
        MenuItem(order, R.drawable.ic_more_lucky_number, R.string.lucky_number_title)

    data class ConferenceMenuItem(override val order: Int = 9) :
        MenuItem(order, R.drawable.ic_more_conferences, R.string.conferences_title)

    data class SchoolAnnouncementsMenuItem(override val order: Int = 10) :
        MenuItem(order, R.drawable.ic_all_about, R.string.school_announcement_title)

    data class SchoolAndTeachersMenuItem(override val order: Int = 11) :
        MenuItem(order, R.drawable.ic_more_schoolandteachers, R.string.teachers_title)

    data class MobileDevicesMenuItem(override val order: Int = 12) :
        MenuItem(order, R.drawable.ic_more_mobile_devices, R.string.mobile_devices_title)
}
