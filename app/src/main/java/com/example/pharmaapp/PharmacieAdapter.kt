package com.example.pharmaapp

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class PharmacieAdapter(private val list: List<Pharmacie>)
    : RecyclerView.Adapter<PharmacieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PharmacieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PharmacieViewHolder, position: Int) {
        val pharmacie: Pharmacie = list[position]
        holder.bind(pharmacie)
    }

    override fun getItemCount(): Int = list.size

}

class PharmacieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.pharmacie_item, parent, false)) {
    private var image: ImageView? = null
    private var nom: TextView? = null
    private var adresse : TextView? = null
    private var dispo : TextView? = null

    init {
        image = itemView.findViewById(R.id.image)
        nom = itemView.findViewById(R.id.nom)
        adresse = itemView.findViewById(R.id.adresse)
        dispo = itemView.findViewById(R.id.dispo)
    }

    fun bind( pharm : Pharmacie) {

        image?.setImageResource(pharm.image)
        nom?.text = pharm.nom
        adresse?.text = pharm.adresse
        dispo?.text = pharm.dispo
    }

}