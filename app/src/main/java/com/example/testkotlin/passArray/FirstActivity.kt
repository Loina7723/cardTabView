package com.example.testkotlin.passArray

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testkotlin.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: ArrayList<TestItem> = ArrayList()
        items.add(TestItem(123, "name", 1))
        items.add(TestItem(234, "name2", 2))

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("items", items)
        startActivity(intent)
    }

}