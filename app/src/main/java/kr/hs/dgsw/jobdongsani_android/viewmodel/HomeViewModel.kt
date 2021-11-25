package kr.hs.dgsw.jobdongsani_android.viewmodel

import android.view.View
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class HomeViewModel: BaseViewModel() {

    val onWritePostClickEvent = SingleLiveEvent<Unit>()
    val onClickBarcodeEvent = SingleLiveEvent<Unit>()

    fun onClickWritePost(view: View?) {
        onWritePostClickEvent.call()
    }

    fun onClickBarcode(view: View?) {
        onClickBarcodeEvent.call()
    }
}