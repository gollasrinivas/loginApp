package com.example.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_users.*

class Users : AppCompatActivity() {
val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        showFragment1()
       btn1.setOnClickListener {
            showFragment1()
        }
        btn2.setOnClickListener {
            showFragment2()
        }
        btn3.setOnClickListener {
            showFragment3()
        }
        logout.setOnClickListener{

            val startAct = Intent(this, MainActivity::class.java)
            val mypre=Shared(this)
            mypre.setIsLogin(false)
            startActivity(startAct)
            this.finish()
        }

    }
    fun showFragment1()
    {
        val transaction=manager.beginTransaction()
        val fragment1 =Fragment1()
       // transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right)
        transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
        transaction.replace(R.id.fragments,fragment1)
        transaction.addToBackStack(null)
        transaction.commit()

    }
    fun showFragment2()
    {
        val transaction=manager.beginTransaction()
        val fragment2 =Fragment2()
       // transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right)
       transaction.setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
        transaction.replace(R.id.fragments,fragment2)
        transaction.addToBackStack(null)
        transaction.commit()

    }
    fun showFragment3()
    {
        val transaction=manager.beginTransaction()
        val fragment3 =Fragment3()
        transaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
        transaction.replace(R.id.fragments,fragment3)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}
