package com.example.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: ArrayList<CardData>
        val bundle = intent.extras
        if(bundle != null) items = bundle.getParcelableArrayList<CardData>("items")!!
        else items = setItems()

        val adapter = LocalAdapter(this)
        for(item in items){
            val page = ViewFragment3(this, item.data)
            adapter.addFragment(page)
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_main)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_main)
        TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = items[position].title
            }
        }).attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val addBtn = findViewById<Button>(R.id.add_btn_main)
                addBtn.setOnClickListener {
                    items[position].data.add("new card")
                    val page = adapter.pages[position] as ViewFragment3
                    page.mAdapter?.notifyItemInserted(items[position].data.size-1)
                }
            }
        })

        val addTabBtn = findViewById<Button>(R.id.addTab_btn_main)
        addTabBtn.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            intent.putExtra("items", items)
            startActivity(intent)
        }
    }

    fun setItems(): ArrayList<CardData> {
        val items: ArrayList<CardData> = ArrayList()

        val data: ArrayList<String> = ArrayList()
        data.add("a")
        data.add("b")
        items.add(CardData("First Cards", data))

        val data2: ArrayList<String> = ArrayList()
        data2.add("c")
        data2.add("d")
        items.add(CardData("Second Cards", data2))

        return items
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