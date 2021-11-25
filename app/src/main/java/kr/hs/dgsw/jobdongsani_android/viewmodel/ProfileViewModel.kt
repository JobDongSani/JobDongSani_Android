package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.local.AppDatabase.Companion.instance
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity
import kr.hs.dgsw.jobdongsani_android.repository.ProfileRepository

class ProfileViewModel : BaseViewModel() {

    val repository = ProfileRepository()

    val onProductListResult = MutableLiveData<List<ProductEntity>>()

    val name = MutableLiveData<String>()

    val phoneNumber = MutableLiveData<String>()
    val userImage = MutableLiveData<String>()
    val username = MutableLiveData<String>()

    init {
        getProfile()
    }

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
        isLoading.value = true

        addDisposable(repository.getProfile(), {
            name.value = it.name
            phoneNumber.value = it.phoneNumber
            userImage.value = it.userImage
            username.value = it.username

            isLoading.value = false
        }, {
            onErrorEvent.value = it
            isLoading.value = false
        })
    }
}