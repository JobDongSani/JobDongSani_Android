package kr.hs.dgsw.jobdongsani_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.repository.AuthRepository
import java.io.File

class SignUpViewModel : BaseViewModel() {

    val isSuccess = MutableLiveData<Boolean>()

    val authRepository = AuthRepository()

    val image = MutableLiveData<File>()
    val nickName = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    fun register() {
        if (nickName.value == null || password.value == null || name.value == null || phone.value == null || image.value == null) {
            onErrorEvent.value = Throwable("모두 입력해주세요")
            return
        }
        isLoading.value = true
        addDisposable(
            authRepository.register(nickName.value!!,
                password.value!!,
                name.value!!,
                phone.value!!, image.value!!), {
                isSuccess.value = true
                isLoading.value = false
            }, {
                isSuccess.value = false
                isLoading.value = false
                onErrorEvent.value = it
            }
        )
    }
}