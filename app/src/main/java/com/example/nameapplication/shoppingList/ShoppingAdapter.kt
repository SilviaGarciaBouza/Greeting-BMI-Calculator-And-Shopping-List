package com.example.nameapplication.shoppingList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R
//filtrar products por categorías:1-pasas onItemSelected que devuelve un Int q será la posición

class ShoppingAdapter(var categoryList: List<Category>, private val onItemSelected:(Int)-> Unit):RecyclerView.Adapter<ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_category_shopping_layout), parent, false)
        return ShoppingViewHolder(view)
    }


    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        //filtrar products por categorías:2-pasas onItemSelected sin los ()

        holder.render (categoryList[position],onItemSelected)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}