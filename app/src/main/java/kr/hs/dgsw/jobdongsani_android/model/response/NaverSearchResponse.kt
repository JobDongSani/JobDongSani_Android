package kr.hs.dgsw.jobdongsani_android.model.response

data class SearchResponse(
    val items: List<Product>
)

data class Product(
    val title: String,
    val barcode: String = ""
)
