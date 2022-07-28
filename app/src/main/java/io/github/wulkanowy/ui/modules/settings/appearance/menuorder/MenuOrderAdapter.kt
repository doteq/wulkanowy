package io.github.wulkanowy.ui.modules.settings.appearance.menuorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.wulkanowy.databinding.ItemMenuOrderBinding
import javax.inject.Inject

class MenuOrderAdapter @Inject constructor() :
    ListAdapter<MenuItem, MenuOrderAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMenuOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(val binding: ItemMenuOrderBinding) : RecyclerView.ViewHolder(binding.root)

    private class DiffCallback : DiffUtil.ItemCallback<MenuItem>() {

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem == newItem

        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem) =
            oldItem.title == newItem.title
    }
}
