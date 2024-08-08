package com.example.productdemoapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_productlist)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val products = RetrofitInstance.api.getProducts()
            val adapter = ProductListAdapter(products.products) { product ->
                val intent = Intent(this@ProductListActivity, ProductDetailActivity::class.java)
                intent.putExtra("product", product)
                startActivity(intent)
            }
            recyclerView.adapter = adapter
        }
    }
}

