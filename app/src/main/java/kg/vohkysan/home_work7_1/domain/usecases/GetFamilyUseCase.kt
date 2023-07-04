package kg.vohkysan.home_work7_1.domain.usecases

import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFamilyUseCase @Inject constructor(private val familyRepository: FamilyRepository) {
    fun execute(): Flow<Resource<List<Family>>> {
        return familyRepository.getFamily()
    }
}