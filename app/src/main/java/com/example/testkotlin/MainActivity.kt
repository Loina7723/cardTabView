package com.example.testkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: ArrayList<CardListData>
        val bundle = intent.extras
        var position: Int? = null
        if(bundle != null){
            items = bundle.getParcelableArrayList<CardListData>("items")!!
            position = bundle.getInt("position")
        }
        else items = setItems()

        val adapter = LocalAdapter(this)
        for(item in items){
            val page = ViewFragment3(this, item.data)
            adapter.addFragment(page)
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager_main)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_main)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
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
                    val intent = Intent(this@MainActivity, ScreenshotActivity::class.java)
                    intent.putExtra("items", items)
                    intent.putExtra("position", position)
                    startActivity(intent)
                }
            }
        })

        val addTabBtn = findViewById<Button>(R.id.addTab_btn_main)
        addTabBtn.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("items", items)
            startActivity(intent)
        }


        if (position != null) viewPager.currentItem = position
    }

    fun setItems(): ArrayList<CardListData> {
        val items: ArrayList<CardListData> = ArrayList()

        val carddata: ArrayList<CardData> = ArrayList()
        carddata.add(CardData(null,  "a", "a detail"))
        carddata.add(CardData(null, "b", "b detail"))
        items.add(CardListData("First Cards", carddata))

        val carddata2: ArrayList<CardData> = ArrayList()
        carddata2.add(CardData(null, "c", "c detail"))
        carddata2.add(CardData(null, "d", "d detail"))
        items.add(CardListData("Second Cards", carddata2))

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

    fun showItems(items: ArrayList<CardListData>){
        for(item in items){
            Log.d(TAG, item.title)
            for(card in item.data){
                Log.d(TAG, card.toString())
            }
        }
    }
}