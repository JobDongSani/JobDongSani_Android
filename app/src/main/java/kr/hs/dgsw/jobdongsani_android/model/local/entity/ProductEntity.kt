package kr.hs.dgsw.jobdongsani_android.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey
    val barcode: String,
    val title: String,
    val wasteType: String,
    val way: String,
)