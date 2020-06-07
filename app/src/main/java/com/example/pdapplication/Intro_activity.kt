package com.example.pdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro_activity.*

class Intro_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_activity)

//        shift to the main activity

        splash_btn.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
            finish()
        }
    }
}
