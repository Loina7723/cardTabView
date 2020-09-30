package com.example.testkotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item.view.*

class RecyclerAdapter(private val mDataList: ArrayList<CardData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mDataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(mDataList[position].img != null){
            val byteArray: ByteArray = mDataList[position].img!!
            val bmp: Bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            holder.img.setImageBitmap(bmp)
        }
        holder.name.text = mDataList[position].card_name
        holder.weight.text = mDataList[position].card_weight
        holder.deleteBtn.setOnClickListener{
            mDataList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var cardview: CardView //同一模組可用(如同地之不同class)(private不同class不可用)
        internal var cardContent: LinearLayout
        internal var img: ImageView
        internal var name: TextView
        internal var weight: TextView
        internal var content: TextView
        internal var deleteBtn: Button

        init {
            cardview = itemView.cardview_CI
            cardContent = itemView.card_LL_CI
            img = itemView.img_CI
            name = itemView.cardName_text_CI
            weight = itemView.weight_text_CI
            content = itemView.content_text_CI
            deleteBtn = itemView.delete_btn_CI
        }
    }
}