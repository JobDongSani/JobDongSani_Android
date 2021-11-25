package kr.hs.dgsw.jobdongsani_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.RecyclePostAdapter.*
import kr.hs.dgsw.jobdongsani_android.adapter.callback.RecyclePostDiffUtilCallBack
import kr.hs.dgsw.jobdongsani_android.databinding.ItemRecyclePostBinding
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class RecyclePostAdapter :
    ListAdapter<ProductEntity, RecyclePostViewHolder>(RecyclePostDiffUtilCallBack) {

    class RecyclePostViewHolder(val binding: ItemRecyclePostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productEntity: ProductEntity) {
            binding.tvArticle.text = productEntity.title
            binding.tvKind.text = "종류: ${productEntity.wasteType}"
            binding.tvRecycleWay.text = "분리수거 방법: ${productEntity.way}"
            binding.layout.setOnLongClickListener {
                onClickDelete.value = productEntity
                return@setOnLongClickListener false
            }
        }

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
        holder.bind(getItem(position))
    }

    companion object {
        val onClickDelete = SingleLiveEvent<ProductEntity>()
    }
}