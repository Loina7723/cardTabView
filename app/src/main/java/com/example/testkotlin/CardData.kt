package com.example.testkotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardData (val title: String, val data: ArrayList<String>) : Parcelable {
}