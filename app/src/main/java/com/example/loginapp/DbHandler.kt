package com.example.loginapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DbHandler(context: Context?) :
    SQLiteOpenHelper(context, "myDb", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table users(id integer primary key autoincrement ,uname TEXT,emails varchar2(35),pass TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists users")
        onCreate(db)
    }

    fun insertUser(sname: String, email: String, pwd: String):Long {


        val db = this.writableDatabase
        try{
            val values = ContentValues()
            values.put("uname", sname)
            values.put("emails", email)
            values.put("pass", pwd)
            val res = db.insert("users", null, values)

            return res
        }
        finally {
            db.close()
        }
    }

    // fun checkUser(usrname:String, pwd:String):Cursor  {
    fun checkUser(user:String,password:String): Boolean {

        val db = writableDatabase
        //val query: String = "select * from users where uname=$usrname and pass=$pwd"
        val query= "select * from users where uname='$user' and pass='$password';"
        var c = db.rawQuery(query, null)
        if(c.count>0)
        {
            c.close()
            return true
        }
        c.close()
        return false



    }


}