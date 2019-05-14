package com.lchow.walletkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add.*
import java.sql.Connection
import java.util.*
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class addFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add,null);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        submit_button.setOnClickListener{

       // clickedButton(this)
        }
    }

   /* fun clickedButton(view: addFragment) {
        val category = CategoryIn.text.toString().toInt()
        val price = PriceIn.text.toString().toInt()
    }*/









    }
