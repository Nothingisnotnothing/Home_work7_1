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
    override fun addFamily(family: Family): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = familyDao.addFamily(family.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
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

    override fun updateFamily(family: Family): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = familyDao.updateFamily(family.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteFamily(family: Family): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = familyDao.deleteFamily(family.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
    }


}