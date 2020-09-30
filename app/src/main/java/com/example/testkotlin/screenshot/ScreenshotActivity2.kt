package com.example.testkotlin.screenshot

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.testkotlin.CardData
import com.example.testkotlin.CardListData
import com.example.testkotlin.MainActivity
import com.example.testkotlin.R
import java.io.ByteArrayOutputStream

class ScreenshotActivity2 : AppCompatActivity() {
    val TAG: String = "ScreenshotActivity"
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenshot)

        var check = true
        var bitmap: Bitmap? = null

        imageView = findViewById<ImageView>(R.id.screenshot_img_ss)

        val yes_button = findViewById<Button>(R.id.yes_btn_ss)
        yes_button.setOnClickListener {
            if(check){
                val main = findViewById<ConstraintLayout>(R.id.main_CL_ss)
                bitmap = takeScreenshot(main)
                imageView.setImageBitmap(bitmap)
                check = false
                yes_button.text = "OK"
            }
            else{
                val bStream = ByteArrayOutputStream()
                bitmap?.compress(Bitmap.CompressFormat.PNG, 100, bStream)
                val byteArray: ByteArray = bStream.toByteArray()

                val intent = Intent(this, CardActivity2::class.java)
                intent.putExtra("image", byteArray)
                startActivity(intent)
            }
        }

        val no_button = findViewById<Button>(R.id.no_btn_ss)
        no_button.setOnClickListener {
            imageView.setImageBitmap(null)
            check = true
            yes_button.text = "screenshot"
        }
    }

    companion object Screenshot {
        private fun takeScreenshot(view: View): Bitmap {
            val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            view.draw(canvas)
            return bitmap
        }
    }
}