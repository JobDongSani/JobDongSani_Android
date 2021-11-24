package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.network.Server
import kr.hs.dgsw.jobdongsani_android.model.network.Server.uploadApi
import kr.hs.dgsw.jobdongsani_android.model.request.SignInRequest
import kr.hs.dgsw.jobdongsani_android.model.request.SignUpRequest
import kr.hs.dgsw.jobdongsani_android.model.response.SignInResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject
import retrofit2.http.Multipart
import java.io.File

class AuthRepository {

    fun login(username: String, password: String): Single<SignInResponse> {
        val signInRequest = SignInRequest(username, password)

        return Server.authService.login(signInRequest).map {

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

    fun register(
        username: String,
        password: String,
        name: String,
        phonenumber: String,
        image: File,
    ): Completable {
        return uploadImage(image).flatMap {
            val signUpRequest = SignUpRequest(username, password, name, phonenumber, it)
            return@flatMap Server.authService.register(signUpRequest)
        }.flatMapCompletable {

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

    fun uploadImage(image: File): Single<String> {
        return uploadApi.uploadImage(MultipartBody.Part.createFormData("file",
            image.name,
            image.asRequestBody("image/*".toMediaType()))).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            if (it.body()?.status != 200) {
                throw Throwable(it.body()?.message)
            }
            it.body()?.data?.fileUrl
        }
    }
}