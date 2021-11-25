package kr.hs.dgsw.jobdongsani_android.model.response

data class TrashShareBoardResponse(
    val id: Int,
    val title: String,
    val contents: String,
    val contact: String,
    val location: String,
    val imagePath: String,
    val writer : String
)
