package com.example.nameapplication.greet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            val name = binding.edClick.text.toString()
            if (name.isNotEmpty()) {
                //crea el intent. Lepasas el context(this) y la activity a la q vas(ResultActivity::class.java)
                val intent = Intent(this, ResultActivity::class.java)
                //para llevarte elementos usas el putExtra y le mandas la clave("Extra_name), y lo q le envias(la variable llamada name)
                intent.putExtra("Extra_name", name)
                //Pasas a esa activity:
                startActivity(intent)
            }
        }
    }
}