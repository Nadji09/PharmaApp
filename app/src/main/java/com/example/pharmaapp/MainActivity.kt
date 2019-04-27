package com.example.pharmaapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //var btn = findViewById<View>(R.id.signup) as Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newcpt.setOnClickListener{
            val intent = Intent(this,Singup::class.java)
            startActivity(intent)
        }


         forget_pwd.setOnClickListener{
             var dia =AlertDialog.Builder(this)
             var inflater=this.layoutInflater
             var pwdview=inflater.inflate(R.layout.activity_pwd_popup,null)
             dia.setView(pwdview)
             dia.show()
         }

    }



}
