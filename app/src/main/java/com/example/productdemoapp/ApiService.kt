package com.example.productdemoapp

import com.example.productdemoapp.model.Product
import com.example.productdemoapp.model.ProductX
import retrofit2.http.GET

interface ApiService {
        @GET("/products")
        suspend fun getProducts(): Product
}

