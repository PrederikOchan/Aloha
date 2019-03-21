package com.rozedfrozzy.aloha.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.rozedfrozzy.aloha.R
import com.rozedfrozzy.aloha.data.UserData
import com.rozedfrozzy.aloha.ui.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.userData = UserData(this)

        checkSession()
        configureUI()
    }

    private fun checkSession() {
        if (viewModel.getSessionStatus()) {
            startActivity<MainActivity>()
            finish()
        }
    }

    private fun configureUI() {
        btnSignIn.setOnClickListener {
            if (validation()) {
                viewModel.saveSession()
                startActivity<MainActivity>()
                finish()
            }
        }
    }

    private fun validation(): Boolean {
        if (inputEmail.text.isEmpty()) {
            inputEmail.error = getString(R.string.required)
            inputEmail.requestFocus()
            return false
        }
        if (inputPassword.text.isEmpty()) {
            inputPassword.error = getString(R.string.required)
            inputPassword.requestFocus()
            return false
        }
        return true
    }
}
