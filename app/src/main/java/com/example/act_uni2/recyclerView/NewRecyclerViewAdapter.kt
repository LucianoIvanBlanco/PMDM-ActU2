package com.example.act_uni2.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.act_uni2.databinding.ItemNewsBinding
import com.example.misnoticias.data.New
import com.bumptech.glide.Glide

class NewRecyclerViewAdapter(
    private val newList: List<New>,
    val actionClick: (titleId: String) -> Unit
) :
    RecyclerView.Adapter<NewRecyclerViewAdapter.NewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {

        val new = newList[position]

        Glide.with(holder.itemView.context)
            .load(new.image)
            .into(holder.binding.ivPerson)
        holder.binding.tvItemTitle.text = new.title
        holder.binding.root.setOnClickListener { actionClick(new.title) }

    }

    override fun getItemCount(): Int {
        return newList.size

    }

    inner class NewViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

}