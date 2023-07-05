package kg.vohkysan.home_work7_1.domain.repositories

import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FamilyRepository {

    suspend fun addFamily(family: Family)

    fun getFamily(): Flow<Resource<List<Family>>>
    fun getFamilyFromLast(): Flow<Resource<List<Family>>>
    fun getFamilySortByName(): Flow<Resource<List<Family>>>

    suspend fun updateFamily(family: Family)

    suspend fun deleteFamily(family: Family)
}