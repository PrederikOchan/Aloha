package com.rozedfrozzy.aloha.ui.login

import androidx.lifecycle.ViewModel
import com.rozedfrozzy.aloha.data.UserData

class LoginViewModel : ViewModel() {
    lateinit var userData: UserData

    fun saveSession() {
        userData.save(UserData.KEY_NAME, true)
    }

    fun getSessionStatus(): Boolean {
         return userData.getSession(UserData.KEY_NAME)
    }
}