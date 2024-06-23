package com.neppplus.sharedpreftest.utils

import android.content.Context

class ContextUtil {

    companion object{
        private val prefName = "TestPref"
        private val AUTO_LOGIN = "AUTO_LOGIN"

        fun setAutoLogin(context: Context, autoLogin : Boolean){
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(AUTO_LOGIN, autoLogin).apply()
        }

        fun getAutoLogin(context: Context):Boolean{
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(AUTO_LOGIN, false)
        }
    }

}