package com.example.pharmaapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ville.*

class VilleFragment: Fragment(), AdapterView.OnItemSelectedListener {

    var pharmaList = mutableListOf<Pharmacie>()
    var displayList = mutableListOf<Pharmacie>()

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var text = parent?.getItemAtPosition(position).toString()
Toast.makeText(parent?.context,text,Toast.LENGTH_SHORT).show()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_ville, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pharmaList = getData()
        // RecyclerView node initialized here
        listPharmacies.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = PharmacieAdapter(displayList)
        }

    searchPharma.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText!!.isNotEmpty()){
            displayList.clear()
            val search = newText.toLowerCase()
            pharmaList.forEach {
                if (it.ville.toLowerCase().contains(search)){
                    displayList.add(it)
                }
            }
        }
        else{
            displayList.clear()
            displayList.addAll(pharmaList)
        }
        listPharmacies.adapter?.notifyDataSetChanged()
    return true
    }
})
    }



    companion object {
        fun newInstance(): VilleFragment = VilleFragment()
    }


    fun getData(): MutableList<Pharmacie>{
        var list = mutableListOf<Pharmacie>()

        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Alger","Ouverte"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Blida","Fermée"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Chlef","Fermée"))
        list.add(Pharmacie("Nom Pharmacie" ,"N°7 Bt 4,cité Benboulaid, Blida",R.drawable.findcalm,"Tipaza","Ouverte"))

        displayList.addAll(list)
        return list
    }
}