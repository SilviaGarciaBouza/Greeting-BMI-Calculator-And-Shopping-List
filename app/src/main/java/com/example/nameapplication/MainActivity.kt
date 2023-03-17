package com.example.nameapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.nameapplication.IMCCalculate.IMCCalculatorActivity
import com.example.nameapplication.greet.NameActivity
import com.example.nameapplication.greet.ResultActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGreet = findViewById<Button>(R.id.btn_greet)
        buttonGreet.setOnClickListener {
            navigateToGreetApp()
        }

        val buttonIMC = findViewById<Button>(R.id.btn_imc_calculator)
        buttonIMC.setOnClickListener{
            navigateToIMCCalculator()
        }
    }



    private fun navigateToGreetApp() {
        val intent = Intent(this, NameActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToIMCCalculator() {
        val intent = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intent)
    }
}



