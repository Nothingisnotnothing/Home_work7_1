package kg.vohkysan.home_work7_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.vohkysan.home_work7_1.data.models.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDao
}