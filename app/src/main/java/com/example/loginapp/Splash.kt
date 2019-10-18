package com.example.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val myprefer = Shared(this)
            if (!myprefer.getIsLogin())
            {
            val startAct = Intent(this, MainActivity::class.java)
            startActivity(startAct)
            this.finish()
        }
            else if(myprefer.getIsLogin())
            {
                val startAct = Intent(this, Users::class.java)
                startActivity(startAct)
                this.finish()
            }
        },1000)
    }
}
