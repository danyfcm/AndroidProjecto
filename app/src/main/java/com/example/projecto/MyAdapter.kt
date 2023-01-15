package com.example.projecto

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.projecto.databinding.ActivityMainBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.InputStream
import java.net.URL

class MyAdapter(private val filmeList : ArrayList<Filme>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) : MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder( holder: MyAdapter.MyViewHolder, position: Int ) {
        val filme : Filme = filmeList[position]

        val storageRef = FirebaseStorage.getInstance().reference.child("images/${filme.Imagem}.jpg")

        val localfile = File.createTempFile("tempImage", "jpg")
        storageRef.getFile(localfile).addOnSuccessListener { 

            val bitmap = BitmapFactory.decodeFile( localfile.absolutePath )
            holder.imageview.setImageBitmap(bitmap)

        }.addOnFailureListener{
            Toast.makeText( holder.imageview.context, "Failed to retreieve image ${filme.Imagem}", Toast.LENGTH_SHORT).show()
        }

        //holder.button.text = filme.Nome

        holder.imageview.setOnClickListener {

            val intent = Intent( holder.imageview.context, FilmeDetalhes::class.java )

            intent.putExtra( "Nome",             filme.Nome )
            intent.putExtra( "Data",             filme.Data )
            intent.putExtra( "Genero",         filme.Genero )
            intent.putExtra( "Imagem",         filme.Imagem )
            intent.putExtra( "Pais",             filme.Pais )
            intent.putExtra( "Realizador", filme.Realizador )
            intent.putExtra( "Sinopse",       filme.Sinopse )

            holder.imageview.context.startActivity( intent )

        }
    }

    override fun getItemCount( ) : Int {
        return filmeList.size
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageview : ImageView = itemView.findViewById(R.id.imageViewFilme)

    }

}