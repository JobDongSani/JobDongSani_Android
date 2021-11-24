package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.SearchPostAdapter.*
import kr.hs.dgsw.jobdongsani_android.adapter.callback.SearchPostDiffUtilCallback
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSearchPostBinding
import kr.hs.dgsw.jobdongsani_android.databinding.ItemSharePostBinding

class SearchPostAdapter : ListAdapter<Any, SearchPostViewHolder>(SearchPostDiffUtilCallback) {


    class SearchPostViewHolder(val binding: ItemSearchPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

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

    }
}