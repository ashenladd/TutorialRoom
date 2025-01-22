package com.example.tutorialroom.data.repository

import androidx.lifecycle.LiveData
import com.example.tutorialroom.data.local.dao.ContactDao
import com.example.tutorialroom.data.local.entity.Contact

class ContactRepository private constructor(
    private val contactDao: ContactDao,
) {
    companion object {
        @Volatile
        private var instance: ContactRepository? = null

        fun getInstance(
            contactDao: ContactDao,
        ): ContactRepository =
            instance ?: synchronized(this) {
                instance ?: ContactRepository(
                    contactDao = contactDao,
                ).also { instance = it }
            }
    }

    suspend fun insertContact(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }

    fun getContacts(): LiveData<List<Contact>> {
        return contactDao.getContacts()
    }
}