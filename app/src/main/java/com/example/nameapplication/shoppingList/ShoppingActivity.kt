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
import com.google.android.material.floatingactionbutton.FloatingActionButton


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

    private lateinit var rvCategory: RecyclerView
    private lateinit var shoppingAdapter: ShoppingAdapter
    private lateinit var rvProduct: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var fabAddProduct: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        initComponents()
        initUI()

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

    @SuppressLint("NotifyDataSetChanged")
    fun updateTasks(){
        productAdapter.notifyDataSetChanged()
    }

    private fun initComponents() {
        rvCategory = findViewById(R.id.rv_shopping_category)
        rvProduct = findViewById(R.id.rv_shopping_product)
        fabAddProduct = findViewById(R.id.fab_shopping_add_product)
    }

    private fun initUI() {
        shoppingAdapter = ShoppingAdapter(categoriesList)
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = shoppingAdapter

        productAdapter = ProductAdapter(productList)
        rvProduct.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvProduct.adapter = productAdapter

       fabAddProduct.setOnClickListener{
            addProduct()
        }
        filterProducts(productList)

    }

    private fun filterProducts(mutableList: MutableList<Product>) {
        //TODO filtrar productos por categorias
       // var filterList: MutableList<Product> = mutableListOf<Product>()
       // mutableList.forEach () {



       // while (product.isSelected= true){ filterList.add(product)}



      //  productList = filterList
        //productos con las categorías selected
        //mostrar solo la lista con esos productos
    }
}