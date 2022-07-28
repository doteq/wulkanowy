package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import io.github.wulkanowy.R
import io.github.wulkanowy.databinding.FragmentMenuOrderBinding
import io.github.wulkanowy.ui.base.BaseFragment
import io.github.wulkanowy.ui.modules.main.MainView
import javax.inject.Inject

@AndroidEntryPoint
class MenuOrderFragment : BaseFragment<FragmentMenuOrderBinding>(R.layout.fragment_menu_order),
    MenuOrderView, MainView.TitledView {

    @Inject
    lateinit var presenter: MenuOrderPresenter

    override val titleStringId = R.string.menu_order_title

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
    }
}
