package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    @SuppressLint("SetTextI18n")
    fun buttonClick(v: View) {

        if(v.id==button_login.id) {

            var dbhelp = DbHandler(this)
            try {
                var cur= dbhelp.checkUser(editText_uuname.text.toString().trim(), editText_password.text.toString().trim())


                if (cur) {
                    val inte = Intent(this, Users::class.java)
                    makeText(this, "hello"+"  "+editText_uuname.text.toString().trim(), Toast.LENGTH_SHORT).show()
                    val mypreference=Shared(this)
                    mypreference.setIsLogin(true)
                    startActivity(inte)
                    this.finish()

                } else {
                    mistakes1.text = "**invalid username or password"
                }
            }catch (e:Exception){
                mistakes1.text =editText_uuname.text.toString().trim()+"  "+ editText_password.text.toString().trim()
            }
        }

        if(v.id==textView_register.id)
        {

            val intent= Intent(this,Register::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}


