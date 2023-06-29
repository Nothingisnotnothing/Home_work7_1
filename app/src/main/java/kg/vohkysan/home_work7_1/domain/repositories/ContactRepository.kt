package kg.vohkysan.home_work7_1.domain.repositories

import kg.vohkysan.home_work7_1.data.models.ContactEntity

interface ContactRepository {

    fun addContact(contactEntity: ContactEntity)

    fun getContacts(): List<ContactEntity>

    fun updateContact(contactEntity: ContactEntity)

    fun deleteContact(contactEntity: ContactEntity)
}