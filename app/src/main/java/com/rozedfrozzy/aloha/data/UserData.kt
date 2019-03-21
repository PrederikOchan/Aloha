package com.rozedfrozzy.aloha.data

import android.content.Context
import android.content.SharedPreferences

class UserData(val context: Context?){

    companion object {
        const val KEY_NAME = "user_session"
    }

    private val USER_PREF = "user_session"
    val userPref: SharedPreferences = context!!.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, status: Boolean) {
        val editor: SharedPreferences.Editor = userPref.edit()
        editor.putBoolean(KEY_NAME, status)
        editor.apply()
    }

    fun delete(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = userPref.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }

    fun getSession(KEY_NAME: String, status: Boolean = false): Boolean {
        return userPref.getBoolean(KEY_NAME, status)
    }
}