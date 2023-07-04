package kg.vohkysan.home_work7_1.domain.usecases

import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import javax.inject.Inject

class UpdateFamilyUseCase @Inject constructor(private val familyRepository: FamilyRepository) {
    fun execute(family: Family) {
        familyRepository.updateFamily(family = family)
    }
}