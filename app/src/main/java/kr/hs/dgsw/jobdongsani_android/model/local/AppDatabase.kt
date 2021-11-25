package kr.hs.dgsw.jobdongsani_android.model.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kr.hs.dgsw.jobdongsani_android.JobDongSaniApp.Companion.context
import kr.hs.dgsw.jobdongsani_android.model.local.dao.ProductDao
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val productDao: ProductDao

    companion object {
        private const val dbName = "ROOM_Practice"
        val instance: AppDatabase? =
            context?.applicationContext?.let {
                Room.databaseBuilder(it, AppDatabase::class.java, dbName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
    }

}