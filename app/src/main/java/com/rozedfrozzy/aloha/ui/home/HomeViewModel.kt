package com.rozedfrozzy.aloha.ui.home

import androidx.lifecycle.ViewModel;
import com.rozedfrozzy.aloha.R

class HomeViewModel : ViewModel() {
    private val listImgLambo = arrayListOf(
        R.drawable.img_lambo_01,
        R.drawable.img_lambo_02,
        R.drawable.img_lambo_03
    )

    private val listImgFerrari = arrayListOf(
        R.drawable.img_ferrari_01,
        R.drawable.img_ferrari_02,
        R.drawable.img_ferrari_03
    )

    private val listImgMercedes = arrayListOf(
        R.drawable.img_mercedes_01,
        R.drawable.img_mercedes_02,
        R.drawable.img_mercedes_03
    )

    fun getImagesLambo() = listImgLambo
    fun getImagesFerrari() = listImgFerrari
    fun getImagesMercedes() = listImgMercedes
}
