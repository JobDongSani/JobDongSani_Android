package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.local.AppDatabase.Companion.instance
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity
import kr.hs.dgsw.jobdongsani_android.model.network.Server.productApi

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

}