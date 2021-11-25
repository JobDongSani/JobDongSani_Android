package kr.hs.dgsw.jobdongsani_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseResponse
import kr.hs.dgsw.jobdongsani_android.model.response.ProfileResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {

    @GET("profile")
    fun getMyInfo(@Header("Authorization") token: String): Single<Response<BaseResponse<ProfileResponse>>>

}