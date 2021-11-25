package kr.hs.dgsw.jobdongsani_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse

object SharedPostDiffCallback: DiffUtil.ItemCallback<TrashShareBoardResponse>() {
    override fun areItemsTheSame(oldItem: TrashShareBoardResponse, newItem: TrashShareBoardResponse): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: TrashShareBoardResponse, newItem: TrashShareBoardResponse): Boolean {
        return oldItem == newItem
    }
}