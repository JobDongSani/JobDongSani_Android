package kr.hs.dgsw.jobdongsani_android.viewmodel.item

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.jobdongsani_android.base.BaseViewModel
import kr.hs.dgsw.jobdongsani_android.util.SingleLiveEvent

class RecycleItemViewModel : BaseViewModel() {

    val deleteEvent = SingleLiveEvent<Unit>()

    val article = MutableLiveData<String>()
    val kind = MutableLiveData<String>()
    val recycleWay = MutableLiveData<String>()
    val dateTime = MutableLiveData<Double>()

    fun bind() {
//        article.value = article.value
//        kind.value = kind.value
//        recycleWay.value = recycleWay.value
//        dateTime.value = dateTime.value
        // TODO: Response 나오면 그거로 변경
    }

    fun onClickDelete() {
        deleteEvent.call()
    }
}