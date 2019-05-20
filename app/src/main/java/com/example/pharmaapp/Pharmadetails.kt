package com.example.pharmaapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pharmadetails.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask

class Pharmadetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmadetails)

        CommandesButton.setOnClickListener{
            val intent = Intent(applicationContext,CommandePharmacieActivity::class.java)

            startActivity(intent)
        }

        AddCommandeButton.setOnClickListener{
            startActivity(intentFor<UploadActivity>().newTask())
        }
    }

}
