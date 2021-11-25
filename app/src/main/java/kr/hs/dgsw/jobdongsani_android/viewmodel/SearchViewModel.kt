package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import kr.hs.dgsw.jobdongsani_android.repository.TrashShareBoardRepository

class SearchViewModel : BaseViewModel() {

    private val trashShareBoardRepository = TrashShareBoardRepository()

    private val allBoard = MutableLiveData<List<TrashShareBoardResponse>>()
    val searchResult = MutableLiveData<List<TrashShareBoardResponse>>()

    val searchWord = MutableLiveData<String>()

    init {
        addDisposable(trashShareBoardRepository.getAllPost(),
            { allBoard.value = it },
            { onErrorEvent.value = it })
    }

    fun searchBoards() {
        searchWord.value?.trim()?.let { search ->
            searchResult.value = allBoard.value?.filter { it.title.contains(search) }
        }
    }

}