package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    @SuppressLint("SetTextI18n")
    fun buttonClick1(v: View) {
        if (v.id == button_register.id) {
            //  if(editText_phone.text.toString()=="")
            //    editText_phone.text.toString().toInt()=0

            if((editText_password.text.toString().trim()==editText_password1.text.toString().trim())&&(editText_password.text.toString().trim().isNotEmpty())&&(editText_username.text.toString().trim().isNotEmpty())&&(editText_email.text.toString().trim().isNotEmpty())&&(editText_email.text.toString().trim().contains("@")))
            {
                Toast.makeText(this,"thanks for registering",Toast.LENGTH_SHORT).show()
                //jbsdkbcksdb
                var dbhelp = DbHandler(this)
                var i= dbhelp.insertUser(editText_username.text.toString().trim(),editText_email.text.toString().trim(),editText_password.text.toString().trim())
                mistakes.text=i.toString()
                val ent= Intent(this,MainActivity::class.java)
                startActivity(ent)
                this.finish()

            }
            else if(editText_password.text.toString().trim()!=editText_password1.text.toString().trim()){
                mistakes.text="**passwords don't match"
            }
            else if(editText_email.text.toString().trim().isEmpty()){
                mistakes.text="**invalid email"
            }
            else if(editText_password.text.toString().trim().isEmpty())
            {
                mistakes.text="**password cannot be empty"
            }
            else if(editText_username.text.toString().trim().isEmpty())
            {
                mistakes.text="**user name cannot be empty"
            }
            else
            {
                mistakes.text="**invalid email"
            }

        }
        if (v.id == textView_login.id) {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

}
