package com.example.productdemoapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductX(
    val id: Int,
    val price: Double,
    val rating: Double,
    val title: String,
    val description: String,
): Parcelable