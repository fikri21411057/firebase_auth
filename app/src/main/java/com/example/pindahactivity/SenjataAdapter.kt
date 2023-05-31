package com.example.pindahactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SenjataAdapter (private val SenjataList: ArrayList<Senjata>): RecyclerView.Adapter<SenjataAdapter.ImageViewHolder>(){

    var onItemClick : ((Senjata) -> Unit)? = null

    class ImageViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id._image)
        val imageTitle : TextView = itemView.findViewById(R.id._title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_senjata,parent,
            false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return SenjataList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val Senjata = SenjataList[position]
        holder.imageView.setImageResource(Senjata.imageSource)
        holder.imageTitle.text = Senjata.imageTitle

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(Senjata)
        }
    }
}