package com.example.nameapplication.shoppingList

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var textProduct: TextView = view.findViewById(R.id.tv_item_products)
    private var checkBox: CheckBox =view.findViewById(R.id.cb_item_products)



    fun render(product: Product){
        textProduct.text = product.name

       itemView.setOnClickListener {
               // product.isSelected = !product.isSelected
              //  if (product.isSelected){
                    checkBox.isChecked
               // } else {!checkBox.isSelected}
          // product.isSelected = checkBox.isChecked

       }

       // }

    }


}
