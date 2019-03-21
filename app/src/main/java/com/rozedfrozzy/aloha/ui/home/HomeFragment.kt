package com.rozedfrozzy.aloha.ui.home

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rozedfrozzy.aloha.R
import com.rozedfrozzy.aloha.ui.home.detail.DetailImageActivity
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var listImages: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        imgClickListener()
    }

    private fun imgClickListener() {
        imgLambo.setOnClickListener{
            listImages = viewModel.getImagesLambo()
            context?.startActivity<DetailImageActivity>(DetailImageActivity.LIST_IMG to listImages)
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        imgFerrari.setOnClickListener{
            listImages = viewModel.getImagesFerrari()
            context?.startActivity<DetailImageActivity>(DetailImageActivity.LIST_IMG to listImages)
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        imgMercedes.setOnClickListener{
            listImages = viewModel.getImagesMercedes()
            context?.startActivity<DetailImageActivity>(DetailImageActivity.LIST_IMG to listImages)
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
