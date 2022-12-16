package com.example.apkwyjazd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnstart).setOnClickListener {
            var kalendarz = findViewById<CalendarView>(R.id.calendarView)
            findViewById<TextView>(R.id.pocz).text = "Początek wyjazdu: " + kalendarz.date
        }

        findViewById<Button>(R.id.btnend).setOnClickListener {
            var kalendarz = findViewById<CalendarView>(R.id.calendarView)
            findViewById<TextView>(R.id.koniec).text = "Koniec wyjazdu: " + kalendarz.date
        }
    }
}