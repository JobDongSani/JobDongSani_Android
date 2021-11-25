package kr.hs.dgsw.jobdongsani_android.model.response


import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    val name: String,
    val phoneNumber: String,
    val userImage: String,
    val username: String
)