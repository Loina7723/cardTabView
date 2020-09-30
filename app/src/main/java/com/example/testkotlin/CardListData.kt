package com.example.testkotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardListData (val title: String, val data: ArrayList<CardData>) : Parcelable {
}