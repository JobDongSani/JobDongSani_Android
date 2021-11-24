package kr.hs.dgsw.jobdongsani_android.model.network.api

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverApi {
    @GET("search/shop.json")
    fun getSearchResult(
        @Query("query") query: String,
        @Header("X-Naver-Client-Id") clientId: String = "DsBcMLHWPNapi7KAHO6C",
        @Header("X-Naver-Client-Secret") clientSecret: String = "yXi3ehMCIB",
    ): Single<SearchResponse>
}