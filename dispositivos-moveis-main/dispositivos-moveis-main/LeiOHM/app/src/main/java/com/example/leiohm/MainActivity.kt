package com.example.leiohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etnV = findViewById<EditText>(R.id.etn_v)
        val etnR = findViewById<EditText>(R.id.etn_r)
        val etnI = findViewById<EditText>(R.id.etn_i)
        val txvFormula = findViewById<TextView>(R.id.txv_formula)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val v = etnV.text.toString().toDoubleOrNull() ?: 0.0
            val r = etnR.text.toString().toDoubleOrNull() ?: 0.0
            val i = etnI.text.toString().toDoubleOrNull() ?: 0.0

            when {
                v == 0.0 && i != 0.0 && r != 0.0 -> {
                    val resultado = i * r
                    txvFormula.text = "V = I * R"
                    etnV.setText(resultado.toString())
                }
                i == 0.0 && v != 0.0 && r != 0.0 -> {
                    val resultado = v / r
                    txvFormula.text = "I = V / R"
                    etnI.setText(resultado.toString())
                }
                r == 0.0 && v != 0.0 && i != 0.0 -> {
                    val resultado = v / i
                    txvFormula.text = "R = V / I"
                    etnR.setText(resultado.toString())
                }
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}