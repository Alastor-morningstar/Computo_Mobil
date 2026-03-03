package com.fic.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val s1 = intent.getStringExtra("num1") ?: "0"
        val s2 = intent.getStringExtra("num2") ?: "0"
        val op = intent.getStringExtra("operacion")

        // 2. Convertir a números para poder operar
        val n1 = s1.toDouble()
        val n2 = s2.toDouble()

        var resultado = 0.0
        var simbolo = ""

        // 3. Lógica según la operación recibida
        when (op) {
            "suma" -> { resultado = n1 + n2; simbolo = "+" }
            "resta" -> { resultado = n1 - n2; simbolo = "-" }
            "multiplicacion" -> { resultado = n1 * n2; simbolo = "*" }
            "division" -> {
                if (n2 != 0.0) {
                    resultado = n1 / n2
                    simbolo = "/"
                } else {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_LONG).show()
                    finish() // Cierra esta activity y regresa
                    return
                }
            }
        }
        // 4. Mostrar el Toast con el resultado
        Toast.makeText(this, "El resultado de $n1 $simbolo $n2 es: $resultado", Toast.LENGTH_LONG).show()
    }
}