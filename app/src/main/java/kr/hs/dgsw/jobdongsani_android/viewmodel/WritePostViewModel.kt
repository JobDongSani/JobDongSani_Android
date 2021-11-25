package kr.hs.dgsw.jobdongsani_android.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent
import java.io.File

class WritePostViewModel : BaseViewModel() {

    val image = MutableLiveData<File>()
    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val local = MutableLiveData<String>()

    val onWritePostSuccessEvent = SingleLiveEvent<Unit>()
    val onWritePostClickEvent = SingleLiveEvent<Unit>()
    val onImagePickEvent = SingleLiveEvent<Unit>()

    val emptyEvent = SingleLiveEvent<Unit>()

    fun onClickWritePost(view: View?) {
        if (title.value.isNullOrBlank() || content.value.isNullOrBlank() || phoneNumber.value.isNullOrBlank() || local.value.isNullOrBlank()) {
            emptyEvent.call()
        } else {
            onWritePostSuccessEvent.call()
        }

    }

    fun onClickImagePick(view: View?) {
        onImagePickEvent.call()
    }
}