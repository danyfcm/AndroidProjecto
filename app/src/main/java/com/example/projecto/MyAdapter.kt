package com.example.projecto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val filmeList : ArrayList<Filme>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) : MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder( holder: MyAdapter.MyViewHolder, position: Int ) {
        val filme : Filme = filmeList[position]

        holder.button.text = filme.Nome
        holder.button.setOnClickListener {

            val intent = Intent(holder.button.context, FilmeDetalhes::class.java)
            intent.putExtra("Nome", filme.Nome)
            intent.putExtra("Data", filme.Data)
            intent.putExtra("Genero", filme.Genero)
            intent.putExtra("Pais", filme.Pais)
            intent.putExtra("Realizador", filme.Realizador)
            intent.putExtra("Sinopse", filme.Sinopse)


            holder.button.context.startActivity(intent)

        }
    }

    override fun getItemCount( ) : Int {
        return filmeList.size
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val button : Button = itemView.findViewById(R.id.buttonFilme)

    }

}