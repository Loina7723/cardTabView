package com.example.testkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item.view.*

class RecyclerAdapter(private val mDataList: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mDataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.quote.text = mDataList[position]
        holder.deleteBtn.setOnClickListener{
            mDataList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var cardview: CardView //同一模組可用(如同地之不同class)(private不同class不可用)
        internal var cardContent: LinearLayout
        internal var quote: TextView
        internal var name: TextView
        internal var deleteBtn: Button

        init {
            cardview = itemView.cardview_CI
            cardContent = itemView.card_LL_CI
            quote = itemView.quote_text_CI
            name = itemView.name_text_CI
            deleteBtn = itemView.delete_btn_CI
        }
    }
}