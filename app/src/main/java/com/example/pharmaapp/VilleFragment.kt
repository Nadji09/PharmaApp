package com.example.pharmaapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ville.*

class VilleFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_ville, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        listPharmacies.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = PharmacieAdapter(getData())
        }
    }

    companion object {
        fun newInstance(): VilleFragment = VilleFragment()
    }

    fun getData(): List<Pharmacie>{
        var list = mutableListOf<Pharmacie>()

        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Blida","Ouverte"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Blida","Fermée"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Blida","Fermée"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Blida","Ouverte"))

        return list
    }
}