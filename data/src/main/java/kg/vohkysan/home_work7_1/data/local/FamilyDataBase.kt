package kg.vohkysan.home_work7_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.vohkysan.home_work7_1.data.models.FamilyEntity

@Database(entities = [FamilyEntity::class], version = 1, exportSchema = false)
abstract class FamilyDataBase : RoomDatabase() {

    abstract fun familyDao(): FamilyDao
}