package com.example.testkotlin.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.testkotlin.R
import java.util.*

class ViewPagerMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<String>()
        data.add("10")
        data.add("20")

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_main)
        val adaper = ViewSliderAdaper(data)
        viewPager.adapter = adaper
    }

    inner class ViewSliderAdaper(var items: ArrayList<String>) : RecyclerView.Adapter<ViewSliderAdaper.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment1_page, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = items[position]
        }

        override fun getItemCount(): Int {
            return items.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var text: TextView

            init {
                text = itemView.findViewById(R.id.fragment1_text)
            }
        }

    }
}