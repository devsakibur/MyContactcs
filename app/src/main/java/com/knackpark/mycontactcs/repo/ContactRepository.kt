package com.knackpark.mycontactcs.repo

import androidx.lifecycle.LiveData
import com.knackpark.mycontactcs.model.Contact
import com.knackpark.mycontactcs.ContactDao

class ContactRepository(val dao : ContactDao)
{
    // function to get all contacts from the database
    fun getAllContacts() : LiveData<List<Contact>> {
        return dao.getAllContacts()
    }

    // function to insert a contact in the database
    fun insertContact(contact : Contact) {dao.insertContact(contact)}

    // function to delete a contact from the database
    fun deleteContact(contact: Contact) {
        dao.delete(contact)
    }
}