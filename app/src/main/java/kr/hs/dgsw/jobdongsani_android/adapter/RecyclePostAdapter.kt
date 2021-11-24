package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.callback.RecyclePostDiffUtilCallBack
import kr.hs.dgsw.jobdongsani_android.databinding.ItemRecyclePostBinding
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class RecyclePostAdapter :
    ListAdapter<Any, RecyclePostAdapter.RecyclePostViewHolder>(RecyclePostDiffUtilCallBack) {

    class RecyclePostViewHolder(val binding: ItemRecyclePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclePostViewHolder =
        RecyclePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_recycle_post,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RecyclePostViewHolder, position: Int) {

    }

    companion object {
        val onClickDelete = SingleLiveEvent<Unit>()
    }
}