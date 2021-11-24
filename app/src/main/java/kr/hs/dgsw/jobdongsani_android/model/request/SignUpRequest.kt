package kr.hs.dgsw.jobdongsani_android.model.request

data class SignUpRequest(
    val username : String,      // id
    val password : String,
    val name : String,
    val phonenumber : String,
    val userImage: String
)
