package com.example.nameapplication.shoppingList

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R
import com.example.nameapplication.R.id.et_dialog
import com.example.nameapplication.databinding.ActivityShoppingBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Collections.list


class ShoppingActivity : AppCompatActivity() {

    private val categoriesList = listOf(
        Category.Carniceria,
        Category.Despensa,
        Category.Pescaderia,
        Category.Congelados,
        Category.Fruteria
    )


    private var productList = mutableListOf(
        Product("Zanahorias", Category.Fruteria),
        Product("Huevos", Category.Despensa),
        Product("tomates", Category.Fruteria),
        Product("Papel de cocina", Category.Despensa),
        Product("Chorizos", Category.Carniceria),
        Product("Helado", Category.Congelados),
        Product("Calamares", Category.Pescaderia)

    )


    private lateinit var shoppingAdapter: ShoppingAdapter
    private lateinit var productAdapter: ProductAdapter

    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }




    private fun initUI() {
        //filtrar products por categorías:5updateCategory

        val categoryListFilter = categoriesList.filter{it.isSelected}

        shoppingAdapter = ShoppingAdapter(categoryListFilter){position -> updateCategories(position)}
        binding.rvShoppingCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvShoppingCategory.adapter = shoppingAdapter


        productAdapter = ProductAdapter(productList)
        binding.rvShoppingProduct.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvShoppingProduct.adapter = productAdapter

        binding.fabShoppingAddProduct.setOnClickListener{
            addProduct()
        }

    }

    private fun addProduct() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.show()

        val editText: EditText = dialog.findViewById(R.id.et_dialog)
        val radioGroup: RadioGroup = dialog.findViewById(R.id.rg_dialog)
        val butonNewProduct: Button = dialog.findViewById(R.id.dialog_button)

        butonNewProduct.setOnClickListener {
            val newProductNAme = editText.text.toString()
            if (newProductNAme.isNotEmpty()) {
                val radioId = radioGroup.checkedRadioButtonId
                val radioButtonSelected: RadioButton = radioGroup.findViewById(radioId)
                val categoryNewProduct = when (radioButtonSelected.text) {
                    getString(R.string.pescaderia) -> Category.Pescaderia
                    else -> Category.Despensa
                }
                val newProduct: Product = Product(newProductNAme, categoryNewProduct)
                productList.add(newProduct)
                updateTasks()
                dialog.hide()
            }
        }
    }



    //Deseleccionar categoría:7- selecciona solo los q son de esa categoría
    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks(){
        val selectCategory: List<Category> = categoriesList.filter { it.isSelected }
        val newProduct = productList.filter { selectCategory.contains(it.category) }
        productAdapter.productList = newProduct

        productAdapter.notifyDataSetChanged()
    }



    //Deseleccionar categoría:6- actualizas category
    private fun updateCategories(position: Int) {
        categoriesList[position].isSelected = !categoriesList[position].isSelected
        shoppingAdapter.notifyItemChanged(position)
        updateTasks()
    }
    /*
    fun filterProducts(mutableList: MutableList<Product>): MutableList<Product> {
            val newListProduct = mutableListOf<Product>()
          val categoryListFilter = categoriesList.filter{it.isSelected}

            categoryListFilter.forEach { item ->
                val productListFilter = mutableList.filter {
                    it.category ==  item
                }
                newListProduct.addAll(productListFilter)
            }

            productList = newListProduct
        return productList
            //updateTasks()
    }

*/
}