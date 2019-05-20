package com.lchow.walletkotlin

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_product_add.*
import java.sql.Connection
import java.util.*
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.text.SimpleDateFormat
import java.time.Year

class addProductFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_add, null);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments

        if (arg != null)
            txtBarcodeValue.setText(arg.getString("params"))


        /*btnScanBarcode.setOnClickListener {

            activity?.let {
                val intent = Intent(it, ScanBarcodeActivity::class.java)
                it.startActivity(intent)
            }

        }*/

        val myCalendar: Calendar = Calendar.getInstance()

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "dd-MM-yyyy"
                val simpleDateFormat = SimpleDateFormat(myFormat, Locale.GERMANY)
                datePickIn.text = simpleDateFormat.format(myCalendar.time)
            }
        }

        btnPickDdate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    activity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })


    }


}


/* fun clickedButton(view: addFragment) {
     val category = CategoryIn.text.toString().toInt()
     val price = PriceIn.text.toString().toInt()
 }*/


