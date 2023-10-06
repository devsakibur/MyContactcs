package com.knackpark.mycontactcs

import androidx.lifecycle.LiveData
import androidx.room.*
import com.knackpark.mycontactcs.model.Contact


@Dao
interface ContactDao {
    @Query("Select * from Contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Delete
    fun delete(contact: Contact)


}