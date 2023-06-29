package kg.vohkysan.home_work7_1.domain.usecases

import kg.vohkysan.home_work7_1.data.models.ContactEntity
import kg.vohkysan.home_work7_1.domain.repositories.ContactRepository

class GetContactsUseCase(private val contactRepository: ContactRepository) {
    fun execute(): List<ContactEntity> {
        return contactRepository.getContacts()
    }
}