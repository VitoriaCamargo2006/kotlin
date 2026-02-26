package com.example.tp2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SegundaActivity : AppCompatActivity(R.layout.activity_segunda) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvNome = findViewById<TextView>(R.id.txv_nomeLivro)
        val txvAutor = findViewById<TextView>(R.id.txv_autor)
        val txvAno = findViewById<TextView>(R.id.txv_ano)
        txvNome.text = intent.getStringExtra("NomeLivro")
        txvAutor.text = intent.getStringExtra("AutorLivro")
        txvAno.text = intent.getStringExtra("AnoLivro")
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_voltar)
        fabVolta.setOnClickListener {
            finish()
        }
    }
}