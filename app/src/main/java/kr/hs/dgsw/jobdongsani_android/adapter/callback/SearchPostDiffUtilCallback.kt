package kr.hs.dgsw.jobdongsani_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil

object SearchPostDiffUtilCallback: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any) = true

    override fun areContentsTheSame(oldItem: Any, newItem: Any) = true
}