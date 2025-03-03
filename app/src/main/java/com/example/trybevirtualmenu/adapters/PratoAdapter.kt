package com.example.trybevirtualmenu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trybevirtualmenu.R
import com.example.trybevirtualmenu.interfaces.OnItemClickListener
import com.example.trybevirtualmenu.models.Prato
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class PratoAdapter(private val pratos: List<Prato>)
    : RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {


    class PratoViewHolder(private val view: View, private val listener:OnItemClickListener?): RecyclerView.ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.item_menu_image)
        val pratoName: MaterialTextView = view.findViewById(R.id.item_menu_name)

        init {
            view.setOnClickListener { listener?.onItemClick(it, adapterPosition)}
        }

    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratoViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_layout, parent, false)
        return PratoViewHolder(view, listener)
    }

    override fun getItemCount(): Int = pratos.size

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        holder.pratoName.text = pratos[position].name
        holder.image.setImageResource(pratos[position].image)
    }
}
