package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.repository.TrashShareBoardRepository
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent
import java.io.File
import java.lang.NullPointerException

class WritePostViewModel : BaseViewModel() {

    private val trashShareBoardRepository = TrashShareBoardRepository()

    val image = MutableLiveData<File>()
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val local = MutableLiveData<String>()

    val onWritePostSuccessEvent = SingleLiveEvent<Int>()

    val emptyEvent = SingleLiveEvent<Unit>()

    fun onClickWritePost() {
        if (title.value.isNullOrBlank() || content.value.isNullOrBlank() || phoneNumber.value.isNullOrBlank() || local.value.isNullOrBlank()) {
            emptyEvent.call()
        } else {
            isLoading.value = true
            addDisposable(
                trashShareBoardRepository.writePost(title.value!!,
                    content.value ?: "",
                    phoneNumber.value ?: "",
                    local.value ?: "",
                    image.value ?: throw NullPointerException()), {
                    onWritePostSuccessEvent.value = it
                    isLoading.value = false
                }, {
                    onErrorEvent.value = it
                    isLoading.value = false
                }
            )
        }

    }

}