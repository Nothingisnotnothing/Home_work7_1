package kg.vohkysan.home_work7_1.domain.usecases

import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import javax.inject.Inject

class DeleteFamilyUseCase @Inject constructor(private val familyRepository: FamilyRepository) {
    suspend fun execute(family: Family) {
        familyRepository.deleteFamily(family = family)
    }
}