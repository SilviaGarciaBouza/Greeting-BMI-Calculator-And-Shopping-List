package com.example.nameapplication.shoppingList

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ShoppingViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val textNameCategory: TextView = view.findViewById(R.id.tv_item_category)
    val cardCategory: CardView = itemView.findViewById(R.id.cv_category)


    fun render(category: Category){
        textNameCategory.text = "Dispensary"
        when (category){
            Category.Despensa -> {textNameCategory.text = "Despensa"}
            Category.Carniceria -> {textNameCategory.text = "Carnicería"}
            Category.Congelados -> {textNameCategory.text = "Congelador"}
            Category.Fruteria -> {textNameCategory.text = "Frutería"}
            Category.Pescaderia -> {textNameCategory.text = "Pescadería"}
        }
       cardCategory.setOnClickListener{
           invSelectedCategoy(category)
            colorCategoy(category)
       }



    }



    fun invSelectedCategoy (category: Category){
        category.isSelected = !category.isSelected}
    fun colorCategoy(category: Category) {
        val colorCategory = if (category.isSelected) {
            ContextCompat.getColor(cardCategory.context, R.color.backgroundCardSelected)
        }
        else{ContextCompat.getColor(cardCategory.context, R.color.backgroundCardNotSelected)}
        cardCategory.setCardBackgroundColor(colorCategory)
    }

}

