package kg.vohkysan.home_work7_1.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kg.vohkysan.home_work7_1.data.models.ContactEntity.Companion.CONTACTS_TABLE

@Entity(tableName = CONTACTS_TABLE)
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    val id: Int,
    @ColumnInfo(name = "contact_name")
    val name: String,
    @ColumnInfo(name = "contact_number")
    val number: Int,
    @ColumnInfo(name = "contact_address")
    val address: String
) {
    companion object {
        const val CONTACTS_TABLE = "contacts_table"
    }
}
