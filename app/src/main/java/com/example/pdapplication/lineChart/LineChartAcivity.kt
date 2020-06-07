package com.example.pdapplication.lineChart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pdapplication.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_line_chart_acivity.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Float.parseFloat
import java.security.KeyStore
import java.util.ArrayList

class LineChartAcivity : AppCompatActivity() {

// the API link

    private var JSON_URL = "https://api.thingspeak.com/channels/1076603/feeds.json?api_key=70US2HWWBB19AQ3J&results=2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart_acivity)

//         initialize the data Array list

        var   data = ArrayList<Entry>()

        // fetch the data from ThingSpeak APi
        var stringRequest = StringRequest(Request.Method.GET , JSON_URL ,  Response.Listener<String> {
            try {
                var obj = JSONObject(it)
                var dataArray = obj.getJSONArray("feeds")

                for (i in 0..dataArray.length()) {

//                    get the data object ( the day , the temprature)

                    var dataObject = dataArray.getJSONObject(i)
                    var dataX = dataObject.getString("created_at")[6].toString()
                    var dataY = dataObject.getString("field1")

//                    add the data to the LineDataSet and setup the line chart

                    data.add(Entry(parseFloat(dataX), parseFloat(dataY)))
                    var lineDataSet = LineDataSet(data , "your Temprature")

                    var iLineDataSets = ArrayList<LineDataSet>()
                    iLineDataSets.add(lineDataSet)

                    var lineData = LineData(lineDataSet)
                    lineChart.setData(lineData)

//                 customize the line chart

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

            }catch (e:JSONException){
                e.printStackTrace()
            }},
            Response.ErrorListener {

//                if the request failed

                Toast.makeText(this , it.message , Toast.LENGTH_LONG).show()
            })

//        add our request to the QUEUE
        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)


//  revoke the line chart

        lineChart.invalidate()



//        set a background color

        lineChart.setBackgroundColor(Color.WHITE)

//        set text if the data are not available

        lineChart.setNoDataText("Data are not available")

    }
}
