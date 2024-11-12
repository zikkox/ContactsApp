package com.example.contactsapp.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addContact()
    }

    private fun addContact(){
        binding.addButton.setOnClickListener(){
            val name = binding.nameTextview.text.toString()
            val number = binding.numberTextview.text.toString()

            val resultIntent = Intent().apply {
                putExtra("Key_Name", name)
                putExtra("Key_Number", number)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}