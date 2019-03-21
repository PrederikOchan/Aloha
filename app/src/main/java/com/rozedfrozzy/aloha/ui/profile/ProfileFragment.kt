package com.rozedfrozzy.aloha.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rozedfrozzy.aloha.R
import com.rozedfrozzy.aloha.data.UserData
import com.rozedfrozzy.aloha.ui.login.LoginActivity
import kotlinx.android.synthetic.main.profile_fragment.*
import org.jetbrains.anko.startActivity

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        viewModel.userData = UserData(context)

        btnClickListener()
    }

    private fun btnClickListener() {
        btnSignOut.setOnClickListener {
            viewModel.deleteSession()
            context?.startActivity<LoginActivity>()
            activity?.finish()
        }
    }

}
