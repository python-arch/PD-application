package com.example.pdapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.pdapplication.R
import kotlinx.android.synthetic.main.activity_test_your_self.*
import org.xmlpull.v1.XmlPullParserFactory


class TestYourSelf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_your_self)

        btnLineChart.setOnClickListener{
            startActivity(Intent(this,LineChartAcivity::class.java))
        }
    }
}
