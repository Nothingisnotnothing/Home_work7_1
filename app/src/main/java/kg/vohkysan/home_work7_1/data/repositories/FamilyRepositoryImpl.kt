package kg.vohkysan.home_work7_1.data.repositories

import kg.vohkysan.home_work7_1.data.local.FamilyDao
import kg.vohkysan.home_work7_1.data.mappers.toFamily
import kg.vohkysan.home_work7_1.data.mappers.toEntity
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class FamilyRepositoryImpl @Inject constructor(private val familyDao: FamilyDao) :
    FamilyRepository {
    override suspend fun addFamily(family: Family) {
        familyDao.addFamily(family.toEntity())
    }

    override suspend fun updateFamily(family: Family){
        familyDao.updateFamily(family.toEntity())    }

    override suspend fun deleteFamily(family: Family){
        familyDao.deleteFamily(family.toEntity())
    }

    override fun getFamily(): Flow<Resource<List<Family>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = familyDao.getFamily()
                val data = list.map { it.toFamily() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getFamilyFromLast(): Flow<Resource<List<Family>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = familyDao.getFamilyFromLast()
                val data = list.map { it.toFamily() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getFamilySortByName(): Flow<Resource<List<Family>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = familyDao.getFamilySortByName()
                val data = list.map { it.toFamily() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}