package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etNomeLivro = findViewById<EditText>(R.id.et_nomeLivro)
        val etAutor = findViewById<EditText>(R.id.et_autor)
        val etAno = findViewById<EditText>(R.id.et_ano)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        var nome=""
        var autor=""
        var ano=""
        btnCadastrar.setOnClickListener {
            nome = "Livro: ${etNomeLivro.text.toString()}"
            autor = "Autor: ${etAutor.text.toString()}"
            ano = "Ano: ${etAno.text.toString()}"
        }
        val favAvanca = findViewById<FloatingActionButton>(R.id.fab_avancar)
        favAvanca.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("NomeLivro",nome)
            intent.putExtra("AutorLivro",autor)
            intent.putExtra("AnoLivro",ano)
            startActivity(intent)
        }
    }
}