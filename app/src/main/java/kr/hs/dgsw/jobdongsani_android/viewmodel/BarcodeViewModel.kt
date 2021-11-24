package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.network.NaverAPI.naverApi
import kr.hs.dgsw.jobdongsani_android.model.response.Product

class BarcodeViewModel : BaseViewModel() {

    val result = MutableLiveData<Product>()

    fun getResult(barcode: String) {
        addDisposable(
            naverApi.getSearchResult(barcode), {
                it.items.firstOrNull()
                    ?.apply { result.value = this }
                    ?: run { onErrorEvent.value = Throwable("상품 정보가 없습니다") }
            }, {
                onErrorEvent.value = it
            }
        )
    }

}