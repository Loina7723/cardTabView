package com.example.testkotlin.addText

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testkotlin.R
import kotlinx.android.synthetic.main.fragment2_page.view.*

class ViewFragment2(var data: Array<String>) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment2_page, container, false)
        val ll = rootView.linearlayout_fg2
        for(item in data) {
            ll.addView(addTextView(ll, item))
        }
        return rootView
    }

    fun addTextView(ll: LinearLayout, item: String): TextView {
        val newView = TextView(ll.context)
        newView.text = item
        return newView
    }
}