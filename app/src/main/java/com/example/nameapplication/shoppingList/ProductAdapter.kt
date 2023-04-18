package com.example.nameapplication.shoppingList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ProductAdapter( var productList: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate((R.layout.item_product_layout), parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.render(productList[position])
    }




    override fun getItemCount(): Int {
        return productList.size
    }
}