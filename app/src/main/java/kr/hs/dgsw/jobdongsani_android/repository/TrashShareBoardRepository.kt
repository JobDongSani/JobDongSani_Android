package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.JobDongSaniApp.Companion.context
import kr.hs.dgsw.jobdongsani_android.model.network.Server
import kr.hs.dgsw.jobdongsani_android.model.network.Server.uploadApi
import kr.hs.dgsw.jobdongsani_android.model.request.TrashShareBoardRequest
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject
import java.io.File

class TrashShareBoardRepository {

    fun writePost(
        title: String,
        contents: String,
        contact: String,
        location: String,
        imageFile: File,
    ): Single<Int> {

        return uploadApi.uploadImage(
            MultipartBody.Part.createFormData("file",
                imageFile.name,
                imageFile.asRequestBody("image/*".toMediaType()))
        ).flatMap {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }

            if (it.body()?.status ?: 400 >= 400) {
                throw Throwable(it.body()?.message)
            }

            val request = TrashShareBoardRequest(title,
                contents,
                contact,
                location,
                it.body()?.data?.fileUrl ?: "")

            val token = context?.getSharedPreferences("SignInActivity", 0)?.getString("token", "") ?: ""

            return@flatMap Server.trashShareBoardApi.writePost("Bearer $token", request)
        }.map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }

            if (it.body()?.status != 201) {
                throw Throwable(it.body()?.message)
            }

            return@map it.body()?.data
        }
    }

    fun getPostById(id: Int): Single<TrashShareBoardResponse> {
        return Server.trashShareBoardApi.getPostById(id).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            if (it.body()?.status != 200) {
                throw Throwable(it.body()?.message)
            }
            it.body()!!.data
        }
    }

    fun getAllPost(): Single<List<TrashShareBoardResponse>> {
        return Server.trashShareBoardApi.getAllPost().map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }

            if (it.body()?.status != 200) {
                throw Throwable(it.body()?.message)
            }

            it.body()!!.data
        }
    }

    fun modifyPost(
        title: String,
        contents: String,
        contact: String,
        location: String,
        imagePath: String,
    ): Single<Int> {

        val request = TrashShareBoardRequest(title, contents, contact, location, imagePath)

        return Server.trashShareBoardApi.modifyPost(request).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            if (it.body()?.status != 200) {
                throw Throwable(it.body()?.message)
            }
            it.body()!!.data
        }
    }

    fun deletePost(accessToken: String, postId: Int): Completable {
        return Server.trashShareBoardApi.deletePost(accessToken, postId).flatMapCompletable {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            if (it.body()?.status != 200) {
                throw Throwable(it.body()?.message)
            }

            return@flatMapCompletable Completable.complete()
        }
    }
}
