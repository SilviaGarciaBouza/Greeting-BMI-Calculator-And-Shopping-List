package com.example.nameapplication.shoppingList

import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var textProduct: TextView = view.findViewById(R.id.tv_item_products)
    private var checkBox: CheckBox =view.findViewById(R.id.cb_item_products)
    val cardProduct: CardView = view.findViewById(R.id.cv_item_products)



    fun render(product: Product){
        textProduct.text = product.name

       cardProduct.setOnClickListener {
           selectedProduct(product)
           crossOut(product)

       }

       // }

    }

    private fun selectedProduct(product: Product) {
        product.isSelected=!product.isSelected
    }

    private fun crossOut(product: Product) {
        if (product.isSelected){
            textProduct.paintFlags = textProduct.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            checkBox.isChecked = true
        }
        else {
            textProduct.paintFlags = textProduct.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            checkBox.isChecked = false
        }
    }



}

