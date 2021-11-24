package kr.hs.dgsw.jobdongsani_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseResponse
import kr.hs.dgsw.jobdongsani_android.model.request.ProductRequest
import kr.hs.dgsw.jobdongsani_android.model.response.ProductResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductApi {

    @GET("product")
    fun getProduct(@Query("barcode") barcode: String): Single<Response<BaseResponse<ProductResponse>>>

    @POST("product")
    fun postProduct(@Body request: ProductRequest): Single<Response<BaseResponse<Any>>>

}