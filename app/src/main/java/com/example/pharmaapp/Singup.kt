package com.example.pharmaapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singup.*

class Singup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        creercpt.setOnClickListener{
            var dia = AlertDialog.Builder(this)
            var inflater=this.layoutInflater
            var pwdview=inflater.inflate(R.layout.activity_signup_popout,null)
            dia.setView(pwdview)
            dia.show()
        }


        deja_inscrit.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
