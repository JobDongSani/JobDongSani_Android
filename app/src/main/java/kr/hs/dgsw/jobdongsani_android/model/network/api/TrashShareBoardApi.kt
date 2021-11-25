package kr.hs.dgsw.jobdongsani_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.base.BaseResponse
import kr.hs.dgsw.jobdongsani_android.model.request.TrashShareBoardRequest
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import retrofit2.Response
import retrofit2.http.*

interface TrashShareBoardApi {
    @POST("/trash-share-board")
    fun writePost(
        @Header("Authorization") accessToken : String,
        @Body trashShareBoardRequest: TrashShareBoardRequest
    ) : Single<Response<BaseResponse<Int>>>

    @GET("/trash-share-board/{id}")
    fun getPostById(
        @Path("id") postId : Int
    ) : Single<Response<BaseResponse<TrashShareBoardResponse>>>

    @GET("/trash-share-board")
    fun getAllPost() : Single<Response<BaseResponse<List<TrashShareBoardResponse>>>>

    @PUT("/trash-share-board/{id}")
    fun modifyPost(
        @Body trashShareBoardRequest: TrashShareBoardRequest
    ) : Single<Response<BaseResponse<Int>>>

    @DELETE("/trash-share-board/{id}")
    fun deletePost(
        @Header("Authorization") accessToken : String,
        @Path("id") postId : Int
    ) : Single<Response<BaseResponse<Any>>>
}