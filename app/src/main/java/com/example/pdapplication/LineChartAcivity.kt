package com.example.pdapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdapplication.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_line_chart_acivity.*
import java.security.KeyStore
import java.util.ArrayList

class LineChartAcivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart_acivity)


// set the data of the line chart
        var data = ArrayList<Entry>()
        data.add(Entry(0F, 10F))
        data.add(Entry(1F,20F))
        data.add(Entry(2F,10F))
        data.add(Entry(3F,30F))
        data.add(Entry(4F,80F))
        data.add(Entry(5F,30F))
        data.add(Entry(6F,40F))

//        Line data set
        var lineDataSet : LineDataSet = LineDataSet(data , "your Temprature")
        var iLineDataSets = ArrayList<LineDataSet>()
        iLineDataSets.add(lineDataSet)

        var lineData = LineData(lineDataSet)
        lineChart.setData(lineData)
        lineChart.invalidate()

//        set a background color
        lineChart.setBackgroundColor(Color.WHITE)

//        set text if the data are not available
        lineChart.setNoDataText("Data are not available")

//        customize the line chart

        lineDataSet.color = Color.GRAY
        lineDataSet.setDrawCircles(true)
        lineDataSet.setCircleColor(Color.GRAY)
        lineDataSet.circleHoleColor = Color.BLACK
        lineDataSet.setDrawCircleHole(true)
        lineDataSet.lineWidth = 5F
        lineDataSet.circleRadius = 10F
        lineDataSet.valueTextSize = 10F
        lineDataSet.valueTextColor = Color.BLACK

    }
}
