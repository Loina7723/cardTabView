package com.example.testkotlin.cardTab

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.R

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardview)

        setCardLinearLayout("A")
        setCardLinearLayout("B")

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView_cv)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val listOfData: ArrayList<String> = ArrayList()
        listOfData.add("a")
        listOfData.add("b")
        listOfData.add("c")
        listOfData.add("d")

        val mAdapter: RecyclerView.Adapter<*> =
            RecyclerAdapter(listOfData)
        recyclerview.adapter = mAdapter
    }

    fun setCardLinearLayout(quote: String){
        val mainLinearLayout = findViewById<LinearLayout>(R.id.linearLayout_cv)

        val cardView = CardView(this)
        cardView.setCardBackgroundColor(Color.parseColor("#009688"))
        cardView.setContentPadding(36, 36, 36, 36)
        cardView.radius = 15f //角的圓滑程度
        cardView.cardElevation = 30f //陰影大小
        val params = RelativeLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(16, 16, 16, 16)
        cardView.layoutParams = params

        val cardLinearLayout = LinearLayout(this)
        cardLinearLayout.orientation = LinearLayout.VERTICAL

        val quoteText = TextView(this)
        quoteText.text = quote
        quoteText.textSize = 24f
        quoteText.setTextColor(Color.WHITE)

        val name = TextView(this)
        name.text = "name"
        name.textSize = 16f
        name.setTextColor(Color.parseColor("#E0F2F1"))
        name.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC)

        cardLinearLayout.addView(quoteText)
        cardLinearLayout.addView(name)
        cardView.addView(cardLinearLayout)
        mainLinearLayout.addView(cardView)
    }

}