package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.repository.TrashShareBoardRepository

class PostDetailViewModel : BaseViewModel() {

    private val trashShareBoardRepository = TrashShareBoardRepository()

    val board = MutableLiveData<TrashShareBoardResponse>()

    fun getTrashShareBoard(id: Int) {
        isLoading.value = true
        addDisposable(
            trashShareBoardRepository.getPostById(id), {
                board.value = it
                isLoading.value = false
            }, {
                onErrorEvent.value = it
                isLoading.value = false
            })
    }

}