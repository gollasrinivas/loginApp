package com.example.loginapp

import android.content.Context

class Shared(context:Context) {
    val PREFERENCES_NAME="loginApp"
    val IS_LOGIN="b"
    val preferences=context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE)
    fun getIsLogin():Boolean{
        return preferences.getBoolean(IS_LOGIN,false)
    }
    fun setIsLogin(login:Boolean)
    {
        val editor=preferences.edit()
        editor.putBoolean(IS_LOGIN,login)
        editor.apply()
    }
}