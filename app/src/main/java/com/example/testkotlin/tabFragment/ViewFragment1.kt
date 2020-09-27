package com.example.testkotlin.tabFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.testkotlin.R
import kotlinx.android.synthetic.main.fragment1_page.view.*

class ViewFragment1(var content: String) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment1_page, container, false)
        val contenTextView = rootView.fragment1_text
        contenTextView.text = content
        return rootView
    }
}