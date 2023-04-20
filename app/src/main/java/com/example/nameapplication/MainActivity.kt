package com.example.nameapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nameapplication.IMCCalculate.IMCCalculatorActivity
import com.example.nameapplication.databinding.ActivityMainBinding
import com.example.nameapplication.developer.view.DeveloperActivity
import com.example.nameapplication.greet.NameActivity
import com.example.nameapplication.sentences.view.SentencesActivity
import com.example.nameapplication.shoppingList.ShoppingActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGreet.setOnClickListener {
            navigateToGreetApp()
        }

        binding.btnImcCalculator.setOnClickListener{
            navigateToIMCCalculator()
        }
        binding.btnShopping.setOnClickListener{
            navigateToShoppingList()
        }
        binding.btnSentences.setOnClickListener{
            navigateToSentences()
        }
        binding.btnSentencesDeveloper.setOnClickListener {
            navigateToDeveloper()
        }
    }

    private fun navigateToSentences() {
        val intent = Intent(this, SentencesActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToGreetApp() {
        val intent = Intent(this, NameActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToIMCCalculator() {
        val intent = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToShoppingList() {
        val intent = Intent(this, ShoppingActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDeveloper(){
        val intent = Intent(this, DeveloperActivity::class.java)
        startActivity(intent)
    }

}



