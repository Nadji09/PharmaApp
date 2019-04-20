package com.example.pharmaapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CommandeAdapter(val ctx: Context, val items: List<Commande>): BaseAdapter() {

    private class ViewHolder(val nom_date: TextView, val pharmacie : TextView, val etat: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder
        if (view == null) {

            view = LayoutInflater.from(ctx).inflate(R.layout.command_layout,parent,false)
            val nom = view?.findViewById(R.id.nom_date) as TextView
            val pharmacie = view?.findViewById(R.id.pharmacie) as TextView
            val etat = view?.findViewById(R.id.etat) as TextView
            viewHolder = ViewHolder(nom,pharmacie,etat)
            view?.setTag(viewHolder)

        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.nom_date.setText(items.get(position).nom_date)
        viewHolder.pharmacie.setText(items.get(position).pharmacy)
        when ( items.get(position).etat ){
            Etat.ENATTENTE -> {
                viewHolder.etat.setText("En attente")
                viewHolder.etat.setTextColor(Color.parseColor("#E67E2E"))
                }
            Etat.TRAITEE ->{
                viewHolder.etat.setText("Traitée")
                viewHolder.etat.setTextColor(Color.parseColor("#2E91AA"))
            }

            Etat.REJETEE ->{
                viewHolder.etat.setText("Rejetée")
                viewHolder.etat.setTextColor(Color.parseColor("#BD473A"))
            }

        }

        return view
    }


    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}