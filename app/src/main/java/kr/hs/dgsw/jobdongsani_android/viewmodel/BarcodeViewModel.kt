package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.local.AppDatabase
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity
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

    fun saveProduct(product: Product) {
        AppDatabase.instance?.productDao?.let {
            addDisposable(
                it.insertProduct(ProductEntity(product.barcode,
                    product.title,
                    product.wasteType,
                    product.way)), {

                }, { t ->
                    onErrorEvent.value = t
                })
        }
    }

}