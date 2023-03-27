package com.example.nameapplication.shoppingList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ShoppingAdapter(var categoryList: List<Category>):RecyclerView.Adapter<ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_category_shopping_layout), parent, false)
        return ShoppingViewHolder(view)
    }


    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.render (categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}