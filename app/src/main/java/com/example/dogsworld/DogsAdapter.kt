package com.example.dogsworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DogsAdapter(private val doglist: ArrayList<Dogs>) :
    RecyclerView.Adapter<DogsAdapter.ViewHolderClass>() {

    var onItemClick: ((Dogs) -> Unit)? = null

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvimage: ImageView = itemView.findViewById(R.id.image)
        val rvtext: TextView = itemView.findViewById(R.id.name)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(doglist[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dog_list, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return doglist.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = doglist[position]
        holder.rvimage.setImageResource(currentItem.image)
        holder.rvtext.text = currentItem.name
    }
}
