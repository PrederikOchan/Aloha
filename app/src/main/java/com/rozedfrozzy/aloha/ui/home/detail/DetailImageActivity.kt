package com.rozedfrozzy.aloha.ui.home.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.rozedfrozzy.aloha.R
import com.smarteist.autoimageslider.SliderLayout
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_detail_image.*
import java.util.ArrayList

class DetailImageActivity : AppCompatActivity() {

    companion object {
        const val LIST_IMG = "list_img"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailImageSlider.setIndicatorAnimation(SliderLayout.Animations.FILL)
        detailImageSlider.scrollTimeInSec = 100

        val getListImg: Bundle? = intent.extras
        getListImg?.let {
            val listImg = getListImg.getIntegerArrayList(LIST_IMG)
            configureSliderImg(listImg)
        }
    }

    private fun configureSliderImg(listImg: ArrayList<Int>?) {
        listImg?.let {
            for (i in listImg) {
                val sliderView = SliderView(this)
                sliderView.setImageDrawable(i)
                sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY)
                detailImageSlider.addSliderView(sliderView)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
