package com.example.pharmaapp

import android.app.AlertDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_singup.*
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class Singup : AppCompatActivity() {

    private val mClient = OkHttpClient()
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext= applicationContext
        setContentView(R.layout.activity_singup)
        creercpt.setOnClickListener{
            var dia = AlertDialog.Builder(this)
            var inflater=this.layoutInflater
            var pwdview=inflater.inflate(R.layout.activity_signup_popout,null)

            /************** sending an SMS **********/

            try {
                post(" http://3fe29565.ngrok.io/sms", object : Callback {

                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                    }

                    @Throws(IOException::class)
                    override fun onResponse(call: Call, response: Response) {
                        runOnUiThread {
                            Toast.makeText(applicationContext, "SMS Sent!", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            } catch (e: IOException) {
                e.printStackTrace()
            }
            /*******************************************/
            dia.setView(pwdview)
            dia.show()

        }


        deja_inscrit.setOnClickListener{
            //val intent = Intent(this,MainActivity::class.java)
            finish()

        }



    }

    @Throws(IOException::class)
    fun post(url: String, callback: Callback): Call {
        val formBody = FormBody.Builder()
            .add("To", "+213658682116")
            .add("Body", "twilio is working ;)")
            .build()
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()
        val response = mClient.newCall(request)
        response.enqueue(callback)
        return response
    }
}
