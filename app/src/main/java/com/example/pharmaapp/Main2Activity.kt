package com.example.pharmaapp

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_commande.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{


    fun loadFragment( fragment:Fragment ): Boolean {

        if( fragment != null){

            supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,fragment,fragment.javaClass.simpleName).commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item : MenuItem): Boolean {
        var fragment = Fragment()
        when(item.itemId ){

            R.id.navigation_commandes -> {
                fragment = CommandesFragment()
            }

            R.id.navigation_ville -> {
                fragment = VilleFragment()
            }

            R.id.navigation_map -> {
                fragment = MapFragment()
            }

        }

        return loadFragment(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        navigation.setOnNavigationItemSelectedListener(this)

    }


}
