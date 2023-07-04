package kg.vohkysan.home_work7_1.domain.repositories

import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface FamilyRepository {

    fun addFamily(family: Family) : Flow<Resource<Unit>>

    fun getFamily(): Flow<Resource<List<Family>>>
    fun getFamilyFromLast(): Flow<Resource<List<Family>>>
    fun getFamilySortByName(): Flow<Resource<List<Family>>>

    fun updateFamily(family: Family) : Flow<Resource<Unit>>

    fun deleteFamily(family: Family) : Flow<Resource<Unit>>
}