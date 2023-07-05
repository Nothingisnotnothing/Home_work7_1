package kg.vohkysan.home_work7_1.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kg.vohkysan.home_work7_1.data.models.FamilyEntity.Companion.FAMILY_TABLE

@Entity(tableName = FAMILY_TABLE)
data class FamilyEntity(
    @PrimaryKey()
    @ColumnInfo(name = "family_id")
    val id: Int,
    @ColumnInfo(name = "family_name")
    val name: String,
    @ColumnInfo(name = "family_mother")
    val mother: String,
    @ColumnInfo(name = "family_father")
    val father: String
) {
    companion object {
        const val FAMILY_TABLE = "family_table"
    }
}
