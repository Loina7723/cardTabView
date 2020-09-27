package com.example.testkotlin.cardTab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.testkotlin.AddItemActivity
import com.example.testkotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*
import kotlin.collections.ArrayList

class CardTabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val now = Calendar.getInstance()
        val helloworld = findViewById<TextView>(R.id.HelloWorld)
        helloworld.text = now.time.toString()

        val items: ArrayList<Item> = ArrayList()

        val data: ArrayList<String> = ArrayList()
        data.add("aa")
        data.add("bb")
        val item =
            Item("First Item", data)
        items.add(item)

        val data2: ArrayList<String> = ArrayList()
        data2.add("cc")
        data2.add("dd")
        val item2 = Item(
            "Second Item",
            data2
        )
        items.add(item2)

        val page =
            ViewFragment3(this, items[0].data)
        val page2 =
            ViewFragment3(this, items[1].data)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_main)
        val adapter =
            LocalAdapter(this)
        adapter.addFragment(page)
        adapter.addFragment(page2)
        viewPager.adapter = adapter
        //滑動頁面監聽
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                Toast.makeText(this@MainActivity, "page $position", Toast.LENGTH_SHORT).show()
//            }
//        })

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_main)
        TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = items[position].title
            }
        }).attach()

        val addBtn = findViewById<Button>(R.id.add_btn_main)
        addBtn.setOnClickListener {
            data.add("cc")
            page.mAdapter?.notifyItemInserted(data.size-1)
        }

        val addTabBtn = findViewById<Button>(R.id.addTab_btn_main)
        addTabBtn.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startActivity(intent)
        }
    }

    class Item(var title: String, var data: ArrayList<String>)

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