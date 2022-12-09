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
        var lista = arrayListOf<TextView>(findViewById(R.id.pocz2),findViewById(R.id.koniec2))

        findViewById<Button>(R.id.Btndod).setOnClickListener {
            var kalendarz = findViewById<CalendarView>(R.id.calendarView)
            for(i in 0..2){
                lista[i].text = kalendarz.date.toString()
            }
        }
    }
}