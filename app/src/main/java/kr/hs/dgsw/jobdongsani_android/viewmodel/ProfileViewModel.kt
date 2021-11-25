package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.local.AppDatabase.Companion.instance
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity

class ProfileViewModel : BaseViewModel() {

    val onProductListResult = MutableLiveData<List<ProductEntity>>()

    fun getSavedProduct() {
        instance?.productDao?.apply {
            addDisposable(
                getAllProduct(), {
                    onProductListResult.value = it
                }, {
                    onErrorEvent.value = it
                }
            )
        }
    }

    fun deleteProduct(productEntity: ProductEntity) {
        instance?.productDao?.apply {
            addDisposable(
                deleteProduct(productEntity), {
                    getSavedProduct()
                }, {
                    onErrorEvent.value = it
                }
            )

        }
    }

    fun getProfile() {

    }

}