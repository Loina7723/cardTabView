package com.example.testkotlin.screenshot

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.testkotlin.R

class CardActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_item)

        val byteArray: ByteArray = intent.getByteArrayExtra("image")!!
        val bmp: Bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

        val imageView = findViewById<ImageView>(R.id.img_CI)
        imageView.setImageBitmap(bmp)
    }
}