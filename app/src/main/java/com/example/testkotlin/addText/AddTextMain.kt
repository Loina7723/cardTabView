package com.example.testkotlin.addText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.testkotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AddTextMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayOf<String>("a", "b")
        val page = ViewFragment2(data)
        val page2 = ViewFragment2(arrayOf("A"))

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_main)
        val adapter = LocalAdapter(this)
        adapter.addFragment(page)
        adapter.addFragment(page2)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_main)
        TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when (position) {
                    0 -> tab.text = "First"
                    1 -> tab.text = "Second"
                    else -> tab.text = "Else"
                }
            }
        }).attach()
    }

    class LocalAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        val pages = ArrayList<Fragment>()

        override fun getItemCount(): Int = pages.size

        override fun createFragment(position: Int): Fragment {
            return pages[position]
        }

        fun addFragment(fragment: Fragment) {
            pages.add(fragment)
        }
    }
}