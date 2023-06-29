package kg.vohkysan.home_work7_1.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kg.vohkysan.home_work7_1.data.models.ContactEntity
import kg.vohkysan.home_work7_1.data.models.ContactEntity.Companion.CONTACTS_TABLE

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContact(contactEntity: ContactEntity)

    @Query("SELECT * FROM $CONTACTS_TABLE")
    suspend fun getContacts(): List<ContactEntity>

    @Update
    suspend fun updateContact(contactEntity: ContactEntity)

    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)
}