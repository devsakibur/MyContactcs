package com.knackpark.mycontactcs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import android.widget.TextView
import com.knackpark.mycontactcs.model.Contact
import com.knackpark.mycontactcs.R

class ContactAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    // Define ViewHolder and methods for binding data here

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to ViewHolder
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        // Return the number of contacts in the list
        return contacts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define UI elements inside the ViewHolder
        private val nameTextView: TextView = itemView.findViewById(R.id.name)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.mobile)
        private val emailTextView: TextView = itemView.findViewById(R.id.email)

        fun bind(contact: Contact) {
            // Bind contact data to UI elements
            nameTextView.text = contact.name
            phoneNumberTextView.text = contact.number
            emailTextView.text = contact.email
        }
    }
}


