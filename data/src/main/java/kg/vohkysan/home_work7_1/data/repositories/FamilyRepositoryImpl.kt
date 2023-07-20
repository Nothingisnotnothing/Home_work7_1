package kg.vohkysan.home_work7_1.data.repositories

import kg.vohkysan.home_work7_1.data.base.BaseRepository
import kg.vohkysan.home_work7_1.data.local.FamilyDao
import kg.vohkysan.home_work7_1.data.mappers.toFamily
import kg.vohkysan.home_work7_1.data.mappers.toEntity
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FamilyRepositoryImpl @Inject constructor(private val familyDao: FamilyDao) :
BaseRepository(), FamilyRepository {
    override suspend fun addFamily(family: Family) {
        familyDao.addFamily(family.toEntity())
    }

    override suspend fun updateFamily(family: Family){
        familyDao.updateFamily(family.toEntity())    }

    override suspend fun deleteFamily(family: Family){
        familyDao.deleteFamily(family.toEntity())
    }

    override fun getFamily(): Flow<Resource<List<Family>>> {
        return doRequest {
            familyDao.getFamily().map { it.toFamily() }
        }
    }

    override fun getFamilyFromLast(): Flow<Resource<List<Family>>> {
        return doRequest {
            familyDao.getFamilySortByName().map { it.toFamily() }
        }
    }

    override fun getFamilySortByName(): Flow<Resource<List<Family>>> {
        return doRequest {
            familyDao.getFamilyFromLast().map { it.toFamily() }
        }
    }
}