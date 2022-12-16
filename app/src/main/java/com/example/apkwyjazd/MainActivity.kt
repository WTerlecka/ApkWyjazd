package com.example.apkwyjazd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var kalendarz = findViewById<CalendarView>(R.id.calendarView)
        var pocz = findViewById<Button>(R.id.btnstart)
        var kon = findViewById<Button>(R.id.btnend)
        var pocz2 = findViewById<TextView>(R.id.pocz)
        var kon2 = findViewById<TextView>(R.id.koniec)
        var il = findViewById<TextView>(R.id.il)



    }
}