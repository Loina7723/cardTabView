package com.example.testkotlin.passArray

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestItem (val id: Long, val name: String, val age: Int) : Parcelable {
}