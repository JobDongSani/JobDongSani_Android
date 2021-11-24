package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.network.Server
import kr.hs.dgsw.jobdongsani_android.model.request.SignInRequest
import kr.hs.dgsw.jobdongsani_android.model.request.SignUpRequest
import kr.hs.dgsw.jobdongsani_android.model.response.SignInResponse
import org.json.JSONObject
import kotlin.math.sign

class AuthRepository {

    fun login(username: String, password: String): Single<SignInResponse> {
        val signInRequest = SignInRequest(username, password)

        return Server.authRetrofit.login(signInRequest).map {

            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            if (it.body()?.code != 200) {
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
    ): Completable {
        val signUpRequest = SignUpRequest(username, password, name, phonenumber)
        return Server.authRetrofit.register(signUpRequest).flatMapCompletable {

            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }

            if (it.body()?.code != 200) {
                throw Throwable(it.body()?.message)
            }

            return@flatMapCompletable Completable.complete()
        }
    }
}