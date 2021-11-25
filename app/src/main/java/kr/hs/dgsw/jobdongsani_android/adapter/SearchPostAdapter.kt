package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.SearchPostAdapter.*
import kr.hs.dgsw.jobdongsani_android.adapter.callback.SearchPostDiffUtilCallback
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSearchPostBinding
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSharePostBinding
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class SearchPostAdapter :
    ListAdapter<TrashShareBoardResponse, SearchPostViewHolder>(SearchPostDiffUtilCallback) {

    companion object {
        val onClick = SingleLiveEvent<Int>()
    }

    class SearchPostViewHolder(val binding: ItemSearchPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TrashShareBoardResponse) {
            binding.tvTitle.text = item.title
            binding.tvWriter.text = item.writer

            Glide.with(binding.root)
                .load(item.imagePath)
                .into(binding.ivThumnail)

            binding.layout.setOnClickListener {
                onClick.value = item.id
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchPostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search_post,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SearchPostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}