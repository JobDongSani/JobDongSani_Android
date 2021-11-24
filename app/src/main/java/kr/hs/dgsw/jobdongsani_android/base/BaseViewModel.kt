package kr.hs.dgsw.jobdongsani_android.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()
    val onErrorEvent = MutableLiveData<Throwable>()

    private val isLoading = MutableLiveData<Boolean>()
    val getIsLoading: LiveData<Boolean> = isLoading

    fun <T> addDisposable(
        single: Single<T>,
        onSuccess: (T) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        disposable.add(
            single.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(onSuccess, onFailure)
        )
    }

    fun addDisposable(
        completable: Completable,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        disposable.add(
            completable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(onSuccess, onFailure)
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}