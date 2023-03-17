package com.example.nameapplication.IMCCalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.nameapplication.R

class ResultIMCCalculatorActivity : AppCompatActivity() {
    lateinit var resultIMC: TextView
    lateinit var quantityIMC: TextView
    lateinit var descriptionIMC: TextView
    lateinit var recalculator: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imccalculator)
        val result: Double = intent.extras?.getDouble("Extra") ?: -1.0
        initComponents()
        setValues(result)
        initClicks()



    }

    private fun setValues(result: Double) {
        when(result) {
            in 0.00..18.50 -> {
               quantityIMC.text= result.toString()
                quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.sobrepesoOpesoInferior))

                //quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.tv_normal))
                resultIMC.text  = getString(R.string.imc_peso_inferior)
                descriptionIMC.text= getString(R.string.imc_peso_inferior_description)
            }
            in 18.51..24.99 -> {
                quantityIMC.text= result.toString()
                quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.tv_normal))

                resultIMC.text  = getString(R.string.imc_normal)
                descriptionIMC.text= getString(R.string.imc_normal_description)
            }
            in 25.00..29.99-> {
                quantityIMC.text = result.toString()
                quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.sobrepesoOpesoInferior))

                resultIMC.text= getString(R.string.imc_sobrepeso)
                descriptionIMC.text= getString(R.string.imc_sobrepeso_description)
            }
            in 30.00..99.99-> {
                quantityIMC.text = result.toString()
                quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.obesidad))

                resultIMC.text = getString(R.string.imc_obesidad)
                descriptionIMC.text= getString(R.string.imc_obesidad_description)
            }
            else -> {
                quantityIMC.text = getString(R.string.error)
                resultIMC.text= getString(R.string.error)
                descriptionIMC.text= getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        resultIMC = findViewById(R.id.tv_result)
        quantityIMC = findViewById(R.id.tv_imc_quantity)
        descriptionIMC = findViewById(R.id.tv_imc_description)
        recalculator = findViewById(R.id.bt_recalcutate_imc)
    }

    private fun initClicks() {
        recalculator.setOnClickListener{ onBackPressed()}
    }

}