package com.example.pharmaapp

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_commande.*

class CommandesFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.activity_commande, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        listCommandes.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = CommandeAdapter(getData())
        }
    }

    companion object {
        fun newInstance(): CommandesFragment = CommandesFragment()
    }

    fun getData(): List<Commande>{
        var list = mutableListOf<Commande>()

        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Roses, Blida",Etat.ENATTENTE))
        list.add(Commande("Toux sèche - 15/02/2019 à 12:12","Nouvelle ère, Blida",Etat.REJETEE))
        list.add(Commande("Grippe sévère - 15/02/2019 à 17:20","Al Qods, Chlef",Etat.TRAITEE))
        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Bananiers, Blida",Etat.TRAITEE))
        list.add(Commande("Allergie - 15/02/2019 à 9:12","Chevaley, Alger",Etat.ENATTENTE))
        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Rose, Blida",Etat.REJETEE))
        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Rose, Blida",Etat.TRAITEE))
        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Rose, Blida",Etat.TRAITEE))

        return list
    }
}