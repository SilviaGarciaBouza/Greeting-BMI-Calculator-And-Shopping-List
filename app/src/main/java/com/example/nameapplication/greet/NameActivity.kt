package com.example.nameapplication.greet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.nameapplication.R

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val butonClick = findViewById<AppCompatButton>(R.id.btn_click)
        val editTextClick = findViewById<AppCompatEditText>(R.id.ed_click)
        butonClick.setOnClickListener {
            val name = editTextClick.text.toString()
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