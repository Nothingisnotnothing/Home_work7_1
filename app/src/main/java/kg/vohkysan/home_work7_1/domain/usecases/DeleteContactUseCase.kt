package kg.vohkysan.home_work7_1.domain.usecases

import kg.vohkysan.home_work7_1.data.models.ContactEntity
import kg.vohkysan.home_work7_1.domain.repositories.ContactRepository

class DeleteContactUseCase(private val contactRepository: ContactRepository) {
    fun execute(contactEntity: ContactEntity) {
        contactRepository.deleteContact(contactEntity)
    }
}