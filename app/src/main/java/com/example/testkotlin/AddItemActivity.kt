package com.example.testkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardview)

        val data = intent.extras
        val items = data?.getParcelableArrayList<CardData>("items")

        val newData: ArrayList<String> = ArrayList()
        newData.add("e")
        newData.add("f")
        items?.add(CardData("Third Cards", newData))

        val button = findViewById<Button>(R.id.button_cv)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("items", items)
            startActivity(intent)
        }
    }
}