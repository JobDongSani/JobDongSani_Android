package kr.hs.dgsw.jobdongsani_android.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.SignInResponse
import kr.hs.dgsw.jobdongsani_android.repository.AuthRepository
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class SignInViewModel() : BaseViewModel() {
    private val authRepository: AuthRepository = AuthRepository()

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val loginEvent = MutableLiveData<String>()
    val onSignUpEvent = SingleLiveEvent<Unit>()

    fun login(view: View?) {
        if (id.value.isNullOrBlank() || pw.value.isNullOrBlank()) {
            throw Throwable("아이디 혹은 패스워드를 입력해주세요")
        } else {
            isLoading.value = true
            addDisposable(authRepository.login(id.value!!, pw.value!!),
                {
                    loginEvent.value = it.accessToken
                    isLoading.value = false
                }, {
                    onErrorEvent.value = it
                    isLoading.value = false
                })
        }
    }

    fun onClickSignUp(view: View?) {
        onSignUpEvent.call()
    }
}