package com.example.testkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val data = intent.extras
        val items = data?.getParcelableArrayList<CardData>("items")


        val button = findViewById<Button>(R.id.button_ai)
        val additemEdittext = findViewById<EditText>(R.id.add_item_ai)
        button.setOnClickListener {
            val newTab = additemEdittext.text.toString()
            if(newTab.length > 0){
                items?.add(CardData(newTab, ArrayList()))
                val intent = Intent(this, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.putExtra("items", items)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Please enter new tab name", Toast.LENGTH_SHORT).show()
        }
    }
}