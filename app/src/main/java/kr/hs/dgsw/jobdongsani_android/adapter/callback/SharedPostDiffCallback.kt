package kr.hs.dgsw.jobdongsani_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil

object SharedPostDiffCallback: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = true
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = true
}