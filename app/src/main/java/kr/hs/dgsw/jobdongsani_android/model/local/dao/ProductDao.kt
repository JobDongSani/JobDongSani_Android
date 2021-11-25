package kr.hs.dgsw.jobdongsani_android.model.local.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductEntity): Completable

    @Query("SELECT * FROM ProductEntity")
    fun getAllProduct(): Single<List<ProductEntity>>

    @Delete
    fun deleteProduct(product: ProductEntity): Completable

}