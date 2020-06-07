package com.example.pdapplication.statistics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdapplication.R
import com.example.pdapplication.TestYourSelf
import kotlinx.android.synthetic.main.activity_slider_info.*


class Slider_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_info)

//        shift to Test your self activity

            feel_sick.setOnClickListener {
                startActivity(Intent(this , TestYourSelf::class.java))
            }

    }
}
