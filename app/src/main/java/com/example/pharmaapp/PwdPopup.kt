package com.example.pharmaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics

class PwdPopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pwd_popup)

        var dm= DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width=dm.widthPixels
        val hight=dm.heightPixels
        window.setLayout((width*0.8).toInt(),(hight*0.45).toInt())

    }
}
