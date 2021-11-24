package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.callback.SharedPostDiffCallback
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSharePostBinding

class SharePostAdapter :
    ListAdapter<Any, SharePostAdapter.SharePostViewHolder>(SharedPostDiffCallback) {

    class SharePostViewHolder(val binding: ItemSharePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SharePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_share_post,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SharePostViewHolder, position: Int) {

    }

}