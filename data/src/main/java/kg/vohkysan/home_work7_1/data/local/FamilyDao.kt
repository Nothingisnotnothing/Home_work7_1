package kg.vohkysan.home_work7_1.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kg.vohkysan.home_work7_1.data.models.FamilyEntity
import kg.vohkysan.home_work7_1.data.models.FamilyEntity.Companion.FAMILY_TABLE

@Dao
interface FamilyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFamily(familyEntity: FamilyEntity)

    @Query("SELECT * FROM $FAMILY_TABLE")
    suspend fun getFamily(): List<FamilyEntity>

    @Query("SELECT * FROM $FAMILY_TABLE ORDER BY family_id DESC")
    suspend fun getFamilyFromLast(): List<FamilyEntity>

    @Query("SELECT * FROM $FAMILY_TABLE ORDER BY family_name ASC")
    suspend fun getFamilySortByName(): List<FamilyEntity>

    @Update
    suspend fun updateFamily(familyEntity: FamilyEntity)

    @Delete
    suspend fun deleteFamily(familyEntity: FamilyEntity)
}