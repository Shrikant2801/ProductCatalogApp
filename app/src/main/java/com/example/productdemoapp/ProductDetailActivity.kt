package com.example.productdemoapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.productdemoapp.model.Product
import com.example.productdemoapp.model.ProductX


class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_productdetail)

        val product = intent.getParcelableExtra<ProductX>("product")
//        Log.d("@@product", product?.description!!)
        findViewById<TextView>(R.id.tvProductDetail).text = product?.description
    }
}