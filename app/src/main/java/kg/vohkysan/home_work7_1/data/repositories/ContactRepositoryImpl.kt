package kg.vohkysan.home_work7_1.data.repositories

import kg.vohkysan.home_work7_1.data.local.ContactDao
import kg.vohkysan.home_work7_1.data.models.ContactEntity
import kg.vohkysan.home_work7_1.domain.repositories.ContactRepository

class ContactRepositoryImpl(private val contactDao: ContactDao) : ContactRepository {
    override fun addContact(contactEntity: ContactEntity) {
        contactDao.addContact(contactEntity)
    }

    override fun getContacts(): List<ContactEntity> {
        return contactDao.getContacts()
    }

    override fun updateContact(contactEntity: ContactEntity) {
        contactDao.updateContact(contactEntity)
    }

    override fun deleteContact(contactEntity: ContactEntity) {
        contactDao.deleteContact(contactEntity)
    }
}