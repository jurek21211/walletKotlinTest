package com.lchow.walletkotlin

import com.github.mikephil.charting.data.PieEntry
import java.sql.*

internal object MysqlCon {
    @JvmStatic
    fun conDB(query:String):ResultSet {
            Class.forName("com.mysql.jdbc.Driver")
            val con = DriverManager.getConnection("jdbc:mysql://sql.s13.vdl.pl/bastionk_wallet", "bastionk_walusr", "MyWalletPal123!" )
            val stmt = con.createStatement()
            val rs = stmt.executeQuery(query)
            con.close()
            return rs
    }

    fun pieDATA(): ArrayList<PieEntry> {
        val yVals:ResultSet
        val vals = ArrayList<PieEntry>()
        Class.forName("com.mysql.jdbc.Driver")
        val con = DriverManager.getConnection("jdbc:mysql://sql.s13.vdl.pl/bastionk_wallet", "bastionk_walusr", "MyWalletPal123!" )
        val stmt = con.createStatement()
        val rs = stmt.executeQuery("SELECT SUM(PRICE), CATEGORY_ID FROM PURCHASES GROUP BY CATEGORY_ID")
        while(rs.next()){
            var X = rs.getInt("SUM(PRICE)").toFloat()
            var Y = rs.getString("CATEGORY_ID")
            vals.add(PieEntry(X,Y))

        }
        con.close()
        return vals
    }
    }



































/*import java.sql.*
import java.util.Properties

class dbConnect {


    val _connection: Connection?
        get() {

            var connection: Connection? = null
            try {
                Class.forName("com.mysql.jdbc.Driver")
                connection =
                    DriverManager.getConnection("jdbc:mysql://sql.s13.vdl.pl", "bastionk_walusr", "MyWalletPal123!")


            } catch (e: Exception) {
                println("CHUJNIA")
                e.printStackTrace()

            }

            return connection
        }

    fun checkME() {
        val obj_check = dbConnect()
        val connection = obj_check._connection
        var ps: PreparedStatement?
        try {
                val query = "SELECT * FROM test"
                ps = connection!!.prepareStatement(query)


            val rs = ps!!.executeQuery()

            while (rs.next()) {
                println(rs.getString("test_Col"))
            }

        } catch (e: SQLException) {
            e.printStackTrace()
        }

    }*/




