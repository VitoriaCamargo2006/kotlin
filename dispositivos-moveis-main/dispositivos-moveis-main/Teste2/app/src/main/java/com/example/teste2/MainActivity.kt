package com.example.teste2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
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

        val etnN1 = findViewById<EditText>(R.id.etnd_n1)
        val etnN2 = findViewById<EditText>(R.id.etnd_n2)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val rbtSomar = findViewById<RadioButton>(R.id.rbt_somar)
        val rbtSubtrair = findViewById<RadioButton>(R.id.rbt_subtrair)
        val rbtMultiplicar = findViewById<RadioButton>(R.id.rbt_multiplicar)
        val rbtDividir = findViewById<RadioButton>(R.id.rbt_dividir)
        val txvOperacao = findViewById<TextView>(R.id.txv_operacao)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener {
            val n1 = etnN1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = etnN2.text.toString().toDoubleOrNull() ?: 0.0

            var operador = ""

            if (rbtSomar.isChecked) operador = "somar"
            else if (rbtSubtrair.isChecked) operador = "subtrair"
            else if (rbtMultiplicar.isChecked) operador = "multiplicar"
            else if (rbtDividir.isChecked) operador = "dividir"
            else operador = "Nenhuma operação selecionada"

            txvOperacao.text = operador

            when (operador) {
                "somar" -> txvResultado.text = (n1 + n2).toString()
                "subtrair" -> txvResultado.text = (n1 - n2).toString()
                "multiplicar" -> txvResultado.text = (n1 * n2).toString()
                "dividir" -> {
                    if (n2 != 0.0) {
                        txvResultado.text = (n1 / n2).toString()
                    } else {
                        txvResultado.text = "Erro: Divisão por 0"
                    }
                }
            }
        }
    }
}