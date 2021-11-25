package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.repository.TrashShareBoardRepository

class HomeViewModel : BaseViewModel() {

    private val trashShareBoardRepository = TrashShareBoardRepository()

    val boardList = MutableLiveData<List<TrashShareBoardResponse>>()

    fun getBoard() {
        addDisposable(
            trashShareBoardRepository.getAllPost(), {
                boardList.value = it
            }, {
                onErrorEvent.value = it
            }
        )
    }

}