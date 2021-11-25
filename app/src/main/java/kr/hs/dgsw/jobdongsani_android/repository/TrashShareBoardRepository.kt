package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.network.Server
import kr.hs.dgsw.jobdongsani_android.model.request.TrashShareBoardRequest
import kr.hs.dgsw.jobdongsani_android.model.response.TrashShareBoardResponse
import org.json.JSONObject

class TrashShareBoardRepository {

    fun writePost(
        title: String,
        contents: String,
        contact: String,
        location: String,
        imagePath: String,
    ): Completable {

        val request = TrashShareBoardRequest(title, contents, contact, location, imagePath)

        return Server.trashShareBoardApi.writePost(request).flatMapCompletable {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }

            if (it.body()?.status != 201) {
                throw Throwable(it.body()?.message)
            }

            return@flatMapCompletable Completable.complete()
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
