package kr.hs.dgsw.jobdongsani_android.model.request

import kr.hs.dgsw.jobdongsani_android.model.response.UserResponse

data class TrashShareBoardRequest(
    val id : String,
    val title: String,
    val content: String,
    val imagePath: String,
    val user : UserResponse
)