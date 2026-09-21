package com.example.cantina_escolar

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var edtQuantidade: EditText
    private lateinit var textResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // pegando os checks Box
        val item1 = findViewById<CheckBox>(R.id.iten1)
        val item2 =findViewById<CheckBox>(R.id.iten2)
        val item3 = findViewById<CheckBox>(R.id.iten3)
        // adicionando os preços:
        val valor1 = 20
        val valor2 = 15
        val valor3 = 10
        // calcular pedido

        val calPedido = findViewById<Button>(R.id.btnCalcular)
        val Nquantidade = findViewById<EditText>(R.id.edtQuantidade)

        calPedido.setOnClickListener {
            val preco = 0
            val total = 0

            if (item1.isChecked){
                preco  += valor1
                total = preco*Nquantidade
            }

        }


    }
}