package com.example.projecto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class FilmeDetalhes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme_detalhes)

        val storageRef = FirebaseStorage.getInstance().reference.child("images/${intent.getStringExtra("Imagem")}.jpg")

        val localfile = File.createTempFile("tempImage", "jpg")
        storageRef.getFile(localfile).addOnSuccessListener {

            val bitmap = BitmapFactory.decodeFile( localfile.absolutePath )
            findViewById<ImageView>( R.id.imageViewDetailsImagem ).setImageBitmap(bitmap)

        }.addOnFailureListener{
            Toast.makeText( this, "Failed to retreieve image ${intent.getStringExtra("Imagem")}", Toast.LENGTH_SHORT).show()
        }

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