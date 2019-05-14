package com.lchow.walletkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_product_add.*
import java.sql.Connection
import java.util.*
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class addProductFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_add,null);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnScanBarcode.setOnClickListener{

            activity?.let{
                val intent = Intent(it, ScanBarcodeActivity::class.java)
                it.startActivity(intent)
            }

        }
    }


    /* fun clickedButton(view: addFragment) {
         val category = CategoryIn.text.toString().toInt()
         val price = PriceIn.text.toString().toInt()
     }*/









}
