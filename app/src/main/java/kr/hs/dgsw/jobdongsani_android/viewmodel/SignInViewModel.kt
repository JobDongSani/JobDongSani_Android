package kr.hs.dgsw.jobdongsani_android.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.model.response.SignInResponse
import kr.hs.dgsw.jobdongsani_android.repository.AuthRepository
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class SignInViewModel(private val authRepository: AuthRepository) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val loginEvent = MutableLiveData<String>()
    val onSignUpEvent = SingleLiveEvent<Unit>()

    fun login(view: View?) {
        addDisposable(authRepository.login(id.value!!, pw.value!!),
            {
                loginEvent.value = it.accessToken
            }, {
                onErrorEvent.value = it
            })
    }

    fun onClickSignUp(view: View?) {
        onSignUpEvent.call()
    }
}