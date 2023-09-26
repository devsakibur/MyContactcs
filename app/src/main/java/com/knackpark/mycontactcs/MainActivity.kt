package com.knackpark.mycontactcs

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val contacts = mutableListOf<Contact>()
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        contactAdapter = ContactAdapter(contacts)
        val recyclerView = findViewById<RecyclerView>(R.id.contactRecyclerView)
        recyclerView.adapter = contactAdapter

        val fabAddContact = findViewById<FloatingActionButton>(R.id.fabAddContact)
        fabAddContact.setOnClickListener {
            showAddContactDialog()
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun showAddContactDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_contact, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(dialogView)
            .setTitle("Add Contact")
            .setPositiveButton("Add") { dialog, _ ->
                val name = dialogView.findViewById<EditText>(R.id.editTextName).text.toString()
                val phoneNumber = dialogView.findViewById<EditText>(R.id.editTextPhoneNumber).text.toString()
                val email = dialogView.findViewById<EditText>(R.id.editTextEmail).text.toString()

                if (name.isNotBlank() && phoneNumber.isNotBlank() && email.isNotBlank()) {
                    val newContact = Contact(name, phoneNumber, email)
                    contacts.add(newContact)
                    contactAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this, "Invalid input. Please check your entries.", Toast.LENGTH_SHORT).show()
                }

                dialog.dismiss()

            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Cancel contact addition
                dialog.dismiss()
            }


        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }


}