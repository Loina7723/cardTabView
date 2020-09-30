package com.example.testkotlin

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardData (val img: ByteArray?, val card_name: String?, val card_weight: String?) : Parcelable {
}