package com.example.pharmaapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class CommandeAdapter(private val list: List<Commande>)
    : RecyclerView.Adapter<CommandeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CommandeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CommandeViewHolder, position: Int) {
        val movie: Commande = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}

class CommandeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.commande_item, parent, false)) {
    private var nom_date: TextView? = null
    private var pharmacie: TextView? = null
    private var etat: TextView? = null


    init {
        nom_date = itemView.findViewById(R.id.nom_date)
        pharmacie = itemView.findViewById(R.id.pharmacie)
        etat = itemView.findViewById(R.id.etat)
    }

    fun bind(commande: Commande) {
        nom_date?.text = commande.nom_date
        pharmacie?.text = commande.pharmacy
        etat?.text = commande.etat.toString()
    }

}