package com.example.nameapplication.shoppingList

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textNameCategory: TextView = view.findViewById(R.id.tv_item_category)
    val cardCategory: CardView = itemView.findViewById(R.id.cv_category)

//filtrar products por categorías:3-pasas onItemSelected

    fun render(category: Category, onItemSelected: (Int) -> Unit) {
        textNameCategory.text = "Dispensary"
        when (category) {
            Category.Despensa -> {
                textNameCategory.text = "Despensa"
            }
            Category.Carniceria -> {
                textNameCategory.text = "Carnicería"
            }
            Category.Congelados -> {
                textNameCategory.text = "Congelador"
            }
            Category.Fruteria -> {
                textNameCategory.text = "Frutería"
            }
            Category.Pescaderia -> {
                textNameCategory.text = "Pescadería"
            }
        }
        //filtrar products por categorías:4-a toda la card le indicas posicion. Escribes todo lo de abajo

        itemView.setOnClickListener { onItemSelected(layoutPosition) }
       // category.isSelected = !category.isSelected
        val colorCategory = if (category.isSelected) {
             R.color.backgroundCardSelected
        } else {
           R.color.backgroundCardNotSelected
        }
        cardCategory.setCardBackgroundColor(ContextCompat.getColor(cardCategory.context, colorCategory))
        // cardCategory.setOnClickListener {
        //   invSelectedCategoy(category)
        // colorCategoy(category)


    }


}


/*

    fun invSelectedCategoy(category: Category) {
        category.isSelected = !category.isSelected
    }

    fun colorCategoy(category: Category) {
        val colorCategory = if (category.isSelected) {
            ContextCompat.getColor(cardCategory.context, R.color.backgroundCardSelected)
        } else {
            ContextCompat.getColor(cardCategory.context, R.color.backgroundCardNotSelected)
        }
        cardCategory.setCardBackgroundColor(colorCategory)
    }
    */




