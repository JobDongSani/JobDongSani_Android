package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.repository.TrashShareBoardRepository

class SearchViewModel: BaseViewModel() {

    private val trashShareBoardRepository = TrashShareBoardRepository()

    val searchResult = MutableLiveData<List<TrashShareBoardResponse>>()

    val searchWord = MutableLiveData<String>()

    fun searchBoards() {
        searchWord.value?.trim()?.let {

        }
    }

}