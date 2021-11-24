package kr.hs.dgsw.jobdongsani_android.base

data class BaseResponse<T>(
    val code: Int,
    val message: String,
    val data: T
)