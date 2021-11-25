package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.callback.SharedPostDiffCallback
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSharePostBinding
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class SharePostAdapter :
    ListAdapter<TrashShareBoardResponse, SharePostAdapter.SharePostViewHolder>(SharedPostDiffCallback) {

    companion object {
        val onClick = SingleLiveEvent<Int>()
    }

    class SharePostViewHolder(val binding: ItemSharePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(item: TrashShareBoardResponse) {
                binding.tvWriter.text = item.writer
                binding.tvTitle.text = item.title
                binding.tvLocal.text = item.location

                Glide.with(binding.root)
                    .load(item.imagePath)
                    .into(binding.ivThumnail)

                binding.layout.setOnClickListener {
                    onClick.value = item.id
                }

            }
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
        holder.bind(getItem(position))
    }

}