package kr.hs.dgsw.jobdongsani_android.repository

import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.network.NaverAPI.naverApi
import kr.hs.dgsw.jobdongsani_android.model.network.Server.productApi
import kr.hs.dgsw.jobdongsani_android.model.response.Product
import kr.hs.dgsw.jobdongsani_android.model.response.ProductResponse
import org.json.JSONObject

class BarcodeRepository {

    fun getProduct(barcode: String): Single<Product> {
        return getProductTitle(barcode).flatMap { title ->
            getWasteType(barcode).map { wasteType ->
                Product("제품명: $title", barcode, wasteType)
            }
        }
    }


    fun getProductTitle(barcode: String): Single<String> {
        return naverApi.getSearchResult(barcode).map {
            if (it.items.isEmpty()) throw Throwable("상품이 존재하지 않습니다")
            it.items[0].title
        }
//
//        return naverApi.getSearchResult(barcode).flatMap { searchResponse ->
//            if (searchResponse.items.isEmpty()) throw Throwable("")
//            else {
//                productApi.getProduct(barcode).map {
//                    if(it.body()?.message == "No value present") {
//                        return@map Product(searchResponse.items[0].title)
//                    }
//                    if (!it.isSuccessful) {
//                        val errorBody = JSONObject(it.errorBody()!!.string())
//                        throw Throwable(errorBody.getString("message"))
//                    }
//                    if (it.body()?.status != 200) {
//                        throw Throwable(it.body()?.message)
//                    }
//
//                    Product(searchResponse.items[0].title,
//                        it.body()!!.data.barcode,
//                        it.body()!!.data.wasteType)
//                }
//            }
//        }
    }

    fun getWasteType(barcode: String): Single<String> {
        return productApi.getProduct(barcode).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                if (errorBody.getString("message") == "No value present") return@map ""
                throw Throwable(errorBody.getString("message"))
            }
            it.body()?.data?.wasteType
        }
    }

}