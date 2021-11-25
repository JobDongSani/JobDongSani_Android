package kr.hs.dgsw.jobdongsani_android.viewmodel

import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.network.Server.productApi
import kr.hs.dgsw.jobdongsani_android.model.request.ProductRequest

class PickWasteTypeViewModel : BaseViewModel() {

    fun postProduct(barcode: String, type: String) {
        isLoading.value = true
        addDisposable(
            productApi.postProduct(ProductRequest(barcode, type)), {
                isLoading.value = false
            }, {
                isLoading.value = false
                onErrorEvent.value = it
            }
        )
    }

}