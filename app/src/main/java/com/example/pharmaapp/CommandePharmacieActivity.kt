package com.example.pharmaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_commande_pharmacie.*

class CommandePharmacieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commande_pharmacie)
        listePCommandes.layoutManager = LinearLayoutManager(this)
            // set the custom adapter to the RecyclerView
        listePCommandes.adapter = CommandeAdapter(getData())

        ReturnButton.setOnClickListener {
            finish()
        }
    }



    fun getData() : List<Commande>{

        var list = mutableListOf<Commande>()

        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Roses, Blida",Etat.ENATTENTE))
        list.add(Commande("Toux sèche - 15/02/2019 à 12:12","Nouvelle ère, Blida",Etat.REJETEE))
        list.add(Commande("Grippe sévère - 15/02/2019 à 17:20","Al Qods, Chlef",Etat.TRAITEE))
        list.add(Commande("Allergie - 15/02/2019 à 12:12","Les Bananiers, Blida",Etat.TRAITEE))

        return list
    }
}
