package com.example.act_uni2.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.act_uni2.databinding.ItemNewsBinding
import com.utad.misnoticias.data.New
import com.bumptech.glide.Glide

class NewRecyclerViewAdapter(private val newList: List<New>, val actionClick: (titleId: String) -> Unit):
    RecyclerView.Adapter<NewRecyclerViewAdapter.NewViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent,false)
        return NewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        // Obtenemos el item de la lista que toca pintar en esa posicion
        val new = newList[position]

        // Pintamos los datos con Glide cargando la imagen desde la URL
        Glide.with(holder.itemView.context)
            .load(new.image)  // new.image es la URL de la imagen
            .into(holder.binding.ivPerson)
       // holder.binding.ivPerson.setImageDrawable(new.image)
        holder.binding.tvItemTitle.text = new.title
        holder.binding.root.setOnClickListener { actionClick(new.title) }

    }

    override fun getItemCount(): Int {
        return newList.size

    }
    inner class NewViewHolder (val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

}