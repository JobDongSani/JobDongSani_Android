package kr.hs.dgsw.jobdongsani_android.model.network

import kr.hs.dgsw.jobdongsani_android.model.network.api.NaverApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NaverAPI {

    val naverApi = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/v1/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NaverApi::class.java)

}