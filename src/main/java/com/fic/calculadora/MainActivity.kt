package com.fic.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botonSuma = findViewById<Button>(R.id.Bsuma)
        val botonResta = findViewById<Button>(R.id.Bresta)
        val botonMultiplicacion = findViewById<Button>(R.id.Bmultiplicacion)
        val botonDivision = findViewById<Button>(R.id.Bdivision)
        val numero1 = findViewById<EditText>(R.id.Numero1)
        val numero2 = findViewById<EditText>(R.id.Numero2)

        botonSuma.setOnClickListener {
            // Acción para el botón de suma
            val n1 = numero1.text.toString()
            val n2 = numero2.text.toString()
            if (n1.isNotEmpty() && n2.isNotEmpty()) {
                val Intent = Intent(this, Resultados::class.java) // Usamos miIntent
                Intent.putExtra("num1", n1)
                Intent.putExtra("num2", n2)
                Intent.putExtra("operacion", "suma")
                startActivity(Intent)
            } else {
                Toast.makeText(this, "Escribe ambos números", Toast.LENGTH_SHORT).show()
            }
        }

        botonResta.setOnClickListener {
            // Acción para el botón de resta
            val n1 = numero1.text.toString()
            val n2 = numero2.text.toString()
            if (n1.isNotEmpty() && n2.isNotEmpty()) {
                val Intent = Intent(this, Resultados::class.java) // Usamos miIntent
                Intent.putExtra("num1", n1)
                Intent.putExtra("num2", n2)
                Intent.putExtra("operacion", "resta")
                startActivity(Intent)
            } else {
                Toast.makeText(this, "Escribe ambos números", Toast.LENGTH_SHORT).show()
            }
        }

        botonMultiplicacion.setOnClickListener {
            // Acción para el botón de multiplicación
            val n1 = numero1.text.toString()
            val n2 = numero2.text.toString()
            if (n1.isNotEmpty() && n2.isNotEmpty()) {
                val Intent = Intent(this, Resultados::class.java) //
                Intent.putExtra("num1", n1)
                Intent.putExtra("num2", n2)
                Intent.putExtra("operacion", "multiplicacion")
                startActivity(Intent)
            } else {
                Toast.makeText(this, "Escribe ambos números", Toast.LENGTH_SHORT).show()
            }
        }

        botonDivision.setOnClickListener {
            // Acción para el botón de división
            val n1 = numero1.text.toString()
            val n2 = numero2.text.toString()
            if (n1.isNotEmpty() && n2.isNotEmpty()) {
                val Intent = Intent(this, Resultados::class.java) //
                Intent.putExtra("num1", n1)
                Intent.putExtra("num2", n2)
                Intent.putExtra("operacion", "division")
                startActivity(Intent)
            } else {
                Toast.makeText(this, "Escribe ambos números", Toast.LENGTH_SHORT).show()
            }
        }
    }
}