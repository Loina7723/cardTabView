package com.example.testkotlin

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {
    var items: ArrayList<CardListData> = ArrayList()

    val TAG = AddItemActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val data = intent.extras
        if(data != null) {
            items = data.getParcelableArrayList<CardListData>("items")!!
            for(item in items){
                Log.d(TAG, "tab: "+item.title)
            }
        }

        val additemEdittext = findViewById<EditText>(R.id.add_item_ai)
        val livingRoom= findViewById<Button>(R.id.livingRoom_ai)
        val kitchen = findViewById<Button>(R.id.kitchen_ai)
        setRoomBtn(livingRoom, additemEdittext)
        setRoomBtn(kitchen, additemEdittext)

        val add_button = findViewById<Button>(R.id.button_ai)
        add_button.setOnClickListener {
            val newTab = additemEdittext.text.toString()
            if(newTab.length > 0){
                if(isTabExist(newTab)){
                    Toast.makeText(this, "The tab has been added, please enter another tab name", Toast.LENGTH_LONG).show()
                }
                else{
                    items.add(CardListData(newTab, ArrayList()))
                    val intent = Intent(this, MainActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    intent.putExtra("items", items)
                    intent.putExtra("position", items.size-1)
                    startActivity(intent)
                }
            }
            else
                Toast.makeText(this, "Please enter new tab name", Toast.LENGTH_SHORT).show()
        }
    }

    fun setRoomBtn(room: Button, additemEdittext: EditText){
        if(isTabExist(room.text.toString())){
            room.setBackgroundResource(R.drawable.btn_round_corner_gray)
            room.setTextColor(Color.parseColor("#D5D5D5"))
            return
        }
        room.setOnClickListener { additemEdittext.text = Editable.Factory.getInstance().newEditable(room.text.toString()) }
    }

    fun isTabExist(tabName: String): Boolean {
        for(item in items)
            if(item.title.equals(tabName))
                return true
        return false
    }
}