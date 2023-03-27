package com.example.nameapplication.shoppingList

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nameapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ShoppingActivity : AppCompatActivity() {

    private val categoriesList = listOf(
        Category.Carniceria,
        Category.Despensa,
        Category.Pescaderia,
        Category.Congelados,
        Category.Fruteria
    )


    private val productList = mutableListOf(
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

       // fabAddProduct.setOnClickListener{
            //addProduct()
        }

    }
}