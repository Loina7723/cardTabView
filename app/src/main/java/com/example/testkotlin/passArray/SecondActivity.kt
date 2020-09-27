package com.example.testkotlin.passArray

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testkotlin.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardview)

        val data = intent.extras
        val items = data?.getParcelableArrayList<TestItem>("items")
        val id = items?.get(0)?.id.toString()

        val button = findViewById<Button>(R.id.button_cv)
        button.text = id
        button.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}