package kr.hs.dgsw.jobdongsani_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseResponse
import kr.hs.dgsw.jobdongsani_android.model.response.UploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.io.File

interface UploadApi {

    @Multipart
    @POST("/file")
    fun uploadImage(
        @Part file : MultipartBody.Part
    ) : Single<Response<BaseResponse<UploadResponse>>>
}