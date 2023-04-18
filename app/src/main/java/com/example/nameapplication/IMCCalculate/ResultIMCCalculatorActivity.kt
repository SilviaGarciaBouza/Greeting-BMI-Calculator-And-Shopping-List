package com.example.nameapplication.IMCCalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityResultImccalculatorBinding

class ResultIMCCalculatorActivity : AppCompatActivity() {


    private lateinit var binding: ActivityResultImccalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImccalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result: Double = intent.extras?.getDouble("Extra") ?: -1.0
        setValues(result)
        initClicks()



    }

    private fun setValues(result: Double) {
        when(result) {
            in 0.00..18.50 -> {
                binding.tvImcQuantity.text= result.toString()
                binding.tvImcQuantity.setTextColor(ContextCompat.getColor(this,R.color.sobrepesoOpesoInferior))

                //quantityIMC.setTextColor(ContextCompat.getColor(this,R.color.tv_normal))
                binding.tvResult.text  = getString(R.string.imc_peso_inferior)
                binding.tvImcDescription.text= getString(R.string.imc_peso_inferior_description)
            }
            in 18.51..24.99 -> {
                binding.tvImcQuantity.text= result.toString()
                binding.tvImcQuantity.setTextColor(ContextCompat.getColor(this,R.color.tv_normal))

                binding.tvResult.text  = getString(R.string.imc_normal)
                binding.tvImcDescription.text= getString(R.string.imc_normal_description)
            }
            in 25.00..29.99-> {
                binding.tvImcQuantity.text = result.toString()
                binding.tvImcQuantity.setTextColor(ContextCompat.getColor(this,R.color.sobrepesoOpesoInferior))

                binding.tvResult.text= getString(R.string.imc_sobrepeso)
                binding.tvImcDescription.text= getString(R.string.imc_sobrepeso_description)
            }
            in 30.00..99.99-> {
                binding.tvImcQuantity.text = result.toString()
                binding.tvImcQuantity.setTextColor(ContextCompat.getColor(this,R.color.obesidad))

                binding.tvResult.text = getString(R.string.imc_obesidad)
                binding.tvImcDescription.text= getString(R.string.imc_obesidad_description)
            }
            else -> {
                binding.tvImcQuantity.text = getString(R.string.error)
                binding.tvResult.text= getString(R.string.error)
                binding.tvImcDescription.text= getString(R.string.error)
            }
        }
    }


    private fun initClicks() {
        binding.btRecalcutateImc.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

}