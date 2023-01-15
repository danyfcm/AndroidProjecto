package com.example.projecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FilmeDetalhes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme_detalhes)

        val textViewNome        = findViewById<TextView>( R.id.textViewDetailsNome       )
        val textViewData        = findViewById<TextView>( R.id.textViewDetailsData       )
        val textViewGenero      = findViewById<TextView>( R.id.textViewDetailsGenero     )
        val textViewPais        = findViewById<TextView>( R.id.textViewDetailsPais       )
        val textViewRealizador  = findViewById<TextView>( R.id.textViewDetailsRealizador )
        val textViewSinopse     = findViewById<TextView>( R.id.textViewDetailsSinopse    )

        textViewNome.text       = intent.getStringExtra( "Nome"       )
        textViewData.text       = intent.getStringExtra( "Data"       )
        textViewGenero.text     = intent.getStringExtra( "Genero"     )
        textViewPais.text       = intent.getStringExtra( "Pais"       )
        textViewRealizador.text = intent.getStringExtra( "Realizador" )
        textViewSinopse.text    = intent.getStringExtra( "Sinopse"    )

    }
}