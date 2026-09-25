package com.example.cantina_escolar

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.component1
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

        textResultado = findViewById(R.id.txtResultado)


        // pegando os checks Box
        val item1 = findViewById<CheckBox>(R.id.iten1)
        val item2 = findViewById<CheckBox>(R.id.iten2)
        val item3 = findViewById<CheckBox>(R.id.iten3)
        // adicionando os preços:

        val valor1 = 20
        val valor2 = 15
        val valor3 = 10
        // calcular pedido

        val calPedido = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        val Nquantidade = findViewById<EditText>(R.id.edtQuantidade)

        calPedido.setOnClickListener {
            Toast.makeText(this, "Botão funcionando!", Toast.LENGTH_SHORT).show()
        }


        calPedido.setOnClickListener {
            calPedido.setOnClickListener {

                val texto = Nquantidade.text.toString()
                val quantidade = texto.toIntOrNull()

                if (quantidade == null) {
                    Toast.makeText(
                        this,
                        "Digite uma quantidade válida",
                        Toast.LENGTH_LONG
                    ).show()

                    return@setOnClickListener
                }

                var preco = 0

                if (item1.isChecked) {
                    preco += valor1
                }

                if (item2.isChecked) {
                    preco += valor2
                }

                if (item3.isChecked) {
                    preco += valor3
                }

                val precoBruto = preco * quantidade

                if (precoBruto >= 50) {

                    val desconto = precoBruto * 0.10
                    val total = precoBruto - desconto

                    textResultado.text =
                        "Preço: R$ %.2f\nDesconto: R$ %.2f\nTotal: R$ %.2f"
                            .format(precoBruto.toDouble(), desconto, total)

                } else {

                    textResultado.text =
                        "Preço: R$ %.2f\nDesconto: R$ 0,00\nTotal: R$ %.2f"
                            .format(precoBruto.toDouble(), precoBruto.toDouble())
                }
            }
            btnLimpar.setOnClickListener {

                // Limpa a quantidade
                Nquantidade.text.clear()

                // Desmarca os produtos
                item1.isChecked = false
                item2.isChecked = false
                item3.isChecked = false

                // Limpa o resultado
                textResultado.text = ""
            }



        }
    }
}