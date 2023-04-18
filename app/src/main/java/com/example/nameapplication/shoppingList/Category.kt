package com.example.nameapplication.shoppingList
//        //filtrar products por categorías:4B-le pasas el var isSelected
sealed class Category (var isSelected: Boolean = true) {
    object Despensa: Category()
    object Carniceria: Category()
    object Pescaderia:Category()
    object Fruteria: Category()
    object Congelados: Category()

}
data class Product(var name: String, var category: Category, var isSelected: Boolean= false)