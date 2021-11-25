package kr.hs.dgsw.jobdongsani_android.model.request

import kr.hs.dgsw.jobdongsani_android.model.response.UserResponse

data class TrashShareBoardRequest(
    val title: String,
    val contents : String,
    val contact : String,
    val location : String,
    val imagePath: String
)