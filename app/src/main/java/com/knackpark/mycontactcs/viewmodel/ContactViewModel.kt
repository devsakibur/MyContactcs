package com.knackpark.mycontactcs.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.knackpark.mycontactcs.ContactDatabase
import com.knackpark.mycontactcs.model.Contact
import com.knackpark.mycontactcs.repo.ContactRepository

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactsDao()
        repository = ContactRepository(dao)
    }
    fun addContacts(contact : Contact){
        repository.insertContact(contact)
    }
    fun getAllContacts() : LiveData<List<Contact>> = repository.getAllContacts()
}