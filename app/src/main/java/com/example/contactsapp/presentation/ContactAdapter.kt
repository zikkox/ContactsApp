package com.example.contactsapp.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.data.Contact
import com.example.contactsapp.databinding.ItemContactBinding

class ContactAdapter(private val contacts: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){


    class ContactViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root){

        private lateinit var addContactLauncher: ActivityResultLauncher<Intent>

        fun displayContacts(contact: Contact) = with(binding){
            initialTextview.text = contact.initial.toString()
            numberTextview.text = contact.number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = contacts.size

     override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
         holder.displayContacts(contacts[position])
         //holder.clickListeners()
    }

}