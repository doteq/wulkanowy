package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

sealed class MenuItem(
    open val order: Int,
    open val icon: Int,
    open val title: Int
) {

    data class StartMenuItem(
        override val order: Int,
        override val icon: Int,
        override val title: Int
    ) : MenuItem(order, icon, title)

    data class GradeMenuItem(
        override val order: Int,
        override val icon: Int,
        override val title: Int
    ) : MenuItem(order, icon, title)

    data class AttendanceMenuItem(
        override val order: Int,
        override val icon: Int,
        override val title: Int
    ) : MenuItem(order, icon, title)

    data class TimetableMenuItem(
        override val order: Int,
        override val icon: Int,
        override val title: Int
    ) : MenuItem(order, icon, title)
}
