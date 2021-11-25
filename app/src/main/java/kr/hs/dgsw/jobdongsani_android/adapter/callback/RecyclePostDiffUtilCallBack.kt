package kr.hs.dgsw.jobdongsani_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity

object RecyclePostDiffUtilCallBack : DiffUtil.ItemCallback<ProductEntity>() {
    override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        return oldItem.barcode == newItem.barcode
    }

    override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        return oldItem == newItem
    }
}