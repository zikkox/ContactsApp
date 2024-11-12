package com.example.contactsapp.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder
import com.example.contactsapp.R
import com.example.contactsapp.data.Contact
import com.example.contactsapp.databinding.ActivityMainBinding
import com.example.contactsapp.databinding.ItemContactBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var contactsList = mutableListOf<Contact>()

    private lateinit var addContactLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addContactLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val name = data?.getStringExtra("Key_Name") ?: "Unknown"
                val number = data?.getStringExtra("Key_Number") ?: "0000"
                val initial = if (name.isNotEmpty()) name[0] else 'U'

                contactsList.add(Contact(name, number, initial))

                initRecyclerView()
            }
        }

        clickListeners()
    }

    private fun initRecyclerView(){
        binding.recyclerView.adapter = ContactAdapter(contactsList)
    }

    private fun clickListeners(){
        binding.contactButton.setOnClickListener(){
            val intent = Intent(this, AddActivity::class.java)
            addContactLauncher.launch(intent)
            initRecyclerView()
        }

    }

}
