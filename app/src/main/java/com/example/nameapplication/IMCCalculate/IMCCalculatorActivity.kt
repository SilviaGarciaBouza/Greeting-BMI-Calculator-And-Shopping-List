package com.example.nameapplication.IMCCalculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityImccalculatorBinding
import com.example.nameapplication.greet.ResultActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.security.KeyStore.TrustedCertificateEntry
import java.text.DecimalFormat

class IMCCalculatorActivity : AppCompatActivity() {


    private lateinit var binding:ActivityImccalculatorBinding

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var weightValue: Int = 60
    private var ageValue: Int = 18
    private var heightNumber: Double = 1000.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImccalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clic()
        colorToClick()
        setWeight()
        setAge()
    }




    private fun clic() {
        binding.male.setOnClickListener {
            changeSelect()
            colorToClick()
        }
        binding.female.setOnClickListener {
            changeSelect()
            colorToClick()
        }
        binding.rsHeight.addOnChangeListener{ _,value,_ ->
            val df = DecimalFormat()
            val result = df.format(value)
            binding.tvHeightQuantity.text = "$result cm"
            heightNumber = result.toDouble()

        }
        binding.tvWeighQuantity.setOnClickListener{
           weightValue -= 1
            setWeight()
        }
        binding.plusWeigh.setOnClickListener{
            weightValue += 1
            setWeight()
        }
        binding.substractAge.setOnClickListener{
            ageValue-= 1
            setAge()
        }
        binding.plusAge.setOnClickListener{
            ageValue+= 1
            setAge()
        }
        binding.btCalcutateImc.setOnClickListener{
            val df = DecimalFormat("#.##")
            var imc:Double = weightValue.toDouble()  / ((heightNumber / 100) * (heightNumber / 100))
            val result = df.format(imc).toDouble()
            val intent = Intent(this, ResultIMCCalculatorActivity::class.java)
            intent.putExtra("Extra",result)
           startActivity(intent)
            //Toast.makeText(this, "$imc", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAge() {
        binding.tvAge.text= ageValue.toString()
    }

    private fun setWeight() {
        binding.tvWeigh.text = weightValue.toString()
    }


    private fun changeSelect() {
        isFemaleSelected = !isFemaleSelected
        isMaleSelected = !isMaleSelected
    }
    private fun colorToClick() {
        binding.male.setCardBackgroundColor(selectColor(isMaleSelected))
        binding.female.setCardBackgroundColor(selectColor(isFemaleSelected))
    }
    private fun selectColor(isSelected: Boolean): Int {
        val colorReference = if (isSelected) {
            R.color.backgroundCardSelected
        } else { R.color.backgroundCardNotSelected }
        return ContextCompat.getColor(this, colorReference)
    }


}
































     /*   val femaleColor = if (isFemaleSelected){
            ContextCompat.getColor(this,R.color.backgroundCardSelected)
        }  else {ContextCompat.getColor(this, R.color.backgroundCardNotSelected)}*/

/*
        if (isMaleSelected) {
            maleColor = ContextCompat.getColor(this, R.color.backgroundCardSelected)
        } else {maleColor = ContextCompat.getColor(this, R.color.backgroundCardNotSelected)}
        if (isFemaleSelected) {
            femaleColor = ContextCompat.getColor(this, R.color.backgroundCardSelected)
        } else {femaleColor = ContextCompat.getColor(this, R.color.backgroundCardNotSelected)}
*/
//retur?
      //  male.setCardBackgroundColor(maleColor)
      //  female.setCardBackgroundColor(maleColor)





/*

 male = findViewById<CardView>(R.id.male)
        female = findViewById<CardView>(R.id.female)

        male.setOnClickListener {
            male.setBackgroundColor(this.resources.getColor(R.color.backgroundCardSelected))
            female.setBackgroundColor(this.resources.getColor(R.color.backgroundCardNotSelected))
        }
        female.setOnClickListener {
            female.setBackgroundColor = ContextCompat.getColor(this, R.color.backgroundCardSelected)
            male.setBackgroundColor(this.resources.getColor(R.color.backgroundCardNotSelected))
        }
    }


 female.setBackgroundColor(this.resources.getColor(R.color.backgroundCardSelected))
            male.setBackgroundColor(this.resources.getColor(R.color.backgroundCardNotSelected))
class IMCCalculatorActivity : AppCompatActivity() {
    lateinit var male: CardView
    lateinit var female: CardView
    var maleSelected: Boolean = true
    var femaleSelected: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
        male = findViewById<CardView>(R.id.male)
        female = findViewById<CardView>(R.id.female)



        male.setOnClickListener {
            isSelected(maleSelected)
        }
        female.setOnClickListener {
            isSelected(femaleSelected)
        }
    }

    private fun isSelected(selected: Boolean) {


        if (selected == maleSelected) {
            male.setBackgroundColor(resources.getColor(R.color.backgroundCardSelected))
            female.setBackgroundColor(resources.getColor(R.color.backgroundCardNotSelected))
        }
        else {
            female.setBackgroundColor(resources.getColor(R.color.backgroundCardSelected))
            male.setBackgroundColor(resources.getColor(R.color.backgroundCardNotSelected))
        }
*/

        /*

        male.cardBackgroundColor = if (maleSelected) {
            R.color.backgroundCardSelected
        }
        else {
        R.color.backgroundCardSelected}
        female.cardBackgroundColor = if(femaleSelected){
            R.color.backgroundCardSelected
        }
        else R.color.backgroundCardNotSelected

    }
    */




