package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.network.NaverAPI.naverApi
import kr.hs.dgsw.jobdongsani_android.model.response.Product
import kr.hs.dgsw.jobdongsani_android.repository.BarcodeRepository

class BarcodeViewModel : BaseViewModel() {
    private val barcodeRepository = BarcodeRepository()

    val result = MutableLiveData<Product>()

    fun getResult(barcode: String) {
        addDisposable(
            barcodeRepository.getProduct(barcode), {
                result.value = it
            }, {
                onErrorEvent.value = it
            }
        )
    }

}