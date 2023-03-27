package com.example.nameapplication.shoppingList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ShoppingViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val textNameCategory: TextView = view.findViewById(R.id.tv_item_category)

    fun render(category: Category){
        textNameCategory.text = "Dispensary"
        when (category){
            Category.Despensa -> {textNameCategory.text = "Despensa"}
            Category.Carniceria -> {textNameCategory.text = "Carnicería"}
            Category.Congelados -> {textNameCategory.text = "Congelador"}
            Category.Fruteria -> {textNameCategory.text = "Frutería"}
            Category.Pescaderia -> {textNameCategory.text = "Pescadería"}
        }
    }

}