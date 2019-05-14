package com.lchow.walletkotlin

import android.graphics.Color
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_home.*
import java.sql.Connection
import java.sql.ResultSet

class HomeFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)

        return inflater.inflate(R.layout.fragment_home,null);


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPieChartData()





    }

    private fun setUpPieChartData() {
        val  myData = MysqlCon.pieDATA()




        val dataSet = PieDataSet(myData, "")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.GRAY)
        colors.add(Color.BLUE)
        colors.add(Color.RED)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)

        dataSet.setColors(colors)
        piechart.animateY(2000,Easing.EaseInOutCubic)
        val data = PieData(dataSet)
        val pieChart = piechart
        pieChart.data = data
        pieChart.centerTextRadiusPercent = 0f
        pieChart.isDrawHoleEnabled = false
        //pieChart.legend.isEnabled = true
        pieChart.description.isEnabled = false
        pieChart.setDragDecelerationFrictionCoef(0.90f)
        pieChart.setDrawHoleEnabled(true)
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setUsePercentValues(true)
    }
}





