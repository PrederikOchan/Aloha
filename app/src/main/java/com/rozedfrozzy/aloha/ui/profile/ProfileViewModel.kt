package com.rozedfrozzy.aloha.ui.profile

import androidx.lifecycle.ViewModel;
import com.rozedfrozzy.aloha.data.UserData

class ProfileViewModel : ViewModel() {
    lateinit var userData: UserData

    fun deleteSession() {
        userData.delete(UserData.KEY_NAME)
    }
}
