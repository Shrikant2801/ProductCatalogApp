package com.example.productdemoapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Product(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)