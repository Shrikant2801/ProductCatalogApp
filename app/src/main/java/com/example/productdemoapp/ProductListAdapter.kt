package com.example.productdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productdemoapp.model.ProductX

class ProductListAdapter(
    private val products: List<ProductX>,
    private val onClick: (ProductX) -> Unit
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private val VIEW_TYPE_TITLE = 0
        private val VIEW_TYPE_PRODUCT = 1

        override fun getItemViewType(position: Int): Int {
            return if (position == 0) VIEW_TYPE_TITLE else VIEW_TYPE_PRODUCT
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return if (viewType == VIEW_TYPE_TITLE) {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
                TitleViewHolder(view)
            } else {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view, onClick)
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (getItemViewType(position) == VIEW_TYPE_TITLE) {
                (holder as TitleViewHolder).bind("Products List")
            } else {
                val product = products[position - 1] // Adjust for title item
                (holder as ProductViewHolder).bind(product)
            }
        }

        override fun getItemCount(): Int {
            return products.size + 1 // +1 for title
        }

        class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val title: TextView = itemView.findViewById(R.id.titleTextView)

            fun bind(titleText: String) {
                title.text = titleText
            }
        }

        class ProductViewHolder(itemView: View, val onClick: (ProductX) -> Unit) : RecyclerView.ViewHolder(itemView) {
            private val productName: TextView = itemView.findViewById(R.id.productNameTextView)
            private val productPrice: TextView = itemView.findViewById(R.id.productPriceTextView)

            fun bind(product: ProductX) {
                productName.text = product.title
                productPrice.text = "$${product.price}"
                itemView.setOnClickListener {
                    onClick(product)
                }
            }
        }
    }
