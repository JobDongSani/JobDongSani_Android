package kr.hs.dgsw.jobdongsani_android.model.network.service

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseResponse
import kr.hs.dgsw.jobdongsani_android.model.request.SignInRequest
import kr.hs.dgsw.jobdongsani_android.model.request.SignUpRequest
import kr.hs.dgsw.jobdongsani_android.model.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/member/signin")
    fun login(
        @Body signInRequest: SignInRequest
    ): Single<retrofit2.Response<BaseResponse<SignInResponse>>>

    @POST("/member/signup")
    fun register(
        @Body signUpRequest: SignUpRequest
    ): Single<retrofit2.Response<BaseResponse<Any>>>
}