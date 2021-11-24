package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.ItemWasteTypeBinding
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class PickWasteTypeAdapter : ListAdapter<String, PickWasteTypeAdapter.PickWasteTypeViewHolder>(
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem

    }
) {


    class PickWasteTypeViewHolder(val binding: ItemWasteTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvType.text = item
            binding.tvType.setOnClickListener { onClick.value = item }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PickWasteTypeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_waste_type,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PickWasteTypeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val onClick = SingleLiveEvent<String>()
    }

}