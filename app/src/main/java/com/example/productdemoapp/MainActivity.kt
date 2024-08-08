package com.example.productdemoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //here to get all data of product list
        lifecycleScope.launch {
            val products = RetrofitInstance.api.getProducts()
            Log.d("@@main", "onCreate: ${products.products.size}")
            Log.d("@@main", "onCreate: ${products.products.first()}")
        }

        findViewById<Button>(R.id.btnViewProducts).setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            startActivity(intent)
        }
    }
}
