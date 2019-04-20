package com.example.pharmaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_commande.*

class CommandeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commande)

        val commandeAdapter = CommandeAdapter(this, getData())
        listView.adapter = commandeAdapter
    }
}

private fun getData() : List<Commande> {
    val list = mutableListOf<Commande>()

    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.TRAITEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Les Roses, Chlef",Etat.ENATTENTE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","La Grande Poste, Alger",Etat.REJETEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.TRAITEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.TRAITEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.REJETEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.REJETEE))
    list.add(Commande("Allergie, envoyée le 11/04/2019 à 11:40","Al Qods, Blida",Etat.ENATTENTE))

    return list
}