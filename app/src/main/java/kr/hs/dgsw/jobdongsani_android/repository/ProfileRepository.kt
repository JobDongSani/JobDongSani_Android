package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.JobDongSaniApp.Companion.context
import kr.hs.dgsw.jobdongsani_android.model.network.Server
import kr.hs.dgsw.jobdongsani_android.model.response.ProfileResponse
import org.json.JSONObject

class ProfileRepository {

    fun getProfile() : Single<ProfileResponse> {
        val token = context?.getSharedPreferences("SignInActivity", 0)?.getString("token", "") ?: ""

        return Server.profileApi.getMyInfo("Bearer $token").map {
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
}