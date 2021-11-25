package kr.hs.dgsw.jobdongsani_android.repository

import kr.hs.dgsw.jobdongsani_android.JobDongSaniApp.Companion.context

class ProfileRepository {

    fun getProfile() {
        val token = context?.getSharedPreferences("SignInActivity", 0)?.getString("token", "") ?: ""
    }

}