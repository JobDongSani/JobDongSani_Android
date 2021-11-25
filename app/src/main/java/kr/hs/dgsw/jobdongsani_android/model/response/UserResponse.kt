package kr.hs.dgsw.jobdongsani_android.model.response

data class UserResponse(
    val name : String,
    val password: String,
    val phoneNumber: String,
    val userImage: String,
    val username: String
)