package com.example.pharmaapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main3.*
import org.jetbrains.anko.textColor

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        search.setOnClickListener {

            it.visibility = View.GONE
            menu.visibility = View.GONE
            titre.visibility = View.GONE

            check.visibility = View.VISIBLE
            back.visibility = View.VISIBLE
            editText.visibility = View.VISIBLE
        }

        check.setOnClickListener {

            it.visibility = View.GONE
            back.visibility = View.GONE
            editText.visibility = View.GONE

            search.visibility = View.VISIBLE
            menu.visibility = View.VISIBLE
            titre.visibility = View.VISIBLE

            titre.text = editText.text

        }


        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                check.performClick()
                return@OnKeyListener true
            }
            false
        })

        editText.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
add.setText(s)

            }
        })
    }
}
