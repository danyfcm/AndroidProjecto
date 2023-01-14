package com.example.projecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FilmeDetalhes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme_detalhes)

        val textView = findViewById<TextView>(R.id.textViewDetails)
        var texto = ""
        texto += "Nome:       " + intent.getStringExtra("Nome") + "\n"
        texto += "Data:       " + intent.getStringExtra("Data") + "\n"
        texto += "Genero:     " + intent.getStringExtra("Genero") + "\n"
        texto += "Pais:       " + intent.getStringExtra("Pais") + "\n"
        texto += "Realizador: " + intent.getStringExtra("Realizador") + "\n"
        texto += "Sinopse:    " + intent.getStringExtra("Sinopse") + "\n"

        textView.text = texto

    }
}