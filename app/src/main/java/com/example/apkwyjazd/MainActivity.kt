package com.example.apkwyjazd

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kalendarz = findViewById<CalendarView>(R.id.calendarView)
        val pocz = findViewById<Button>(R.id.btnstart)
        val kon = findViewById<Button>(R.id.btnend)
        val pocz2 = findViewById<TextView>(R.id.pocz)
        val kon2 = findViewById<TextView>(R.id.koniec)
        val il = findViewById<TextView>(R.id.il)

        kalendarz.minDate = System.currentTimeMillis()
        kalendarz.maxDate = LocalDate.now().plusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        kalendarz.setFirstDayOfWeek(Calendar.MONDAY);

        val dataPocz = mutableListOf<Int>(0,0,0)
        val dataKon = mutableListOf<Int>(0,0,0)
        val data = arrayListOf<Int>(MilliToDate(kalendarz.date)[0],MilliToDate(kalendarz.date)[1], MilliToDate(kalendarz.date)[2])

        kalendarz.setOnDateChangeListener(){CalendarView, dzien, mies, rok ->
            data[0] = dzien
            data[1] = mies +1
            data[2] = rok
        }

        pocz.setOnClickListener {
            dataPocz[0] = data[0]
            dataPocz[1] = data[1]
            dataPocz[2] = data[2]
            pocz2.text = "Początek wyjazdu: " +data[0].toString()+"-"+data[1].toString()+"-"+data[2].toString();
        }

        kon.setOnClickListener {
            dataKon[0] = data[0]
            dataKon[1] = data[1]
            dataKon[2] = data[2]
            kon2.text = "Koniec wyjazdu: " +data[0].toString()+"-"+data[1].toString()+"-"+data[2].toString();

            if(dataPocz[0] != 0 && dataKon[0] != 0)
                if(dataPocz[0] > dataKon[0] || dataPocz[2] > dataKon[2] && dataPocz[1] == dataKon[1])
                    il.text = "Nie można sie cofać w czasie :)"
                else
                    nazwa(dataPocz, dataKon, il)
        }
    }
}
fun MilliToDate(milli : Long) : List<Int>
{
    val date = Date(milli)
    val formatter = SimpleDateFormat("yyyy/MM/dd")
    val formattedDate = formatter.format(date)
    val ans = formattedDate.split("/").map{ it.toInt() }
    return ans;
}

fun nazwa(dataKon : MutableList<Int>, dataPocz : MutableList<Int>, il : TextView){
    val temp1 = (dataKon[0]*360) + (dataKon[1]*30) + dataKon[2]
    val temp2 = (dataPocz[0]*360) + (dataPocz[1]*30) + dataPocz[2]
    val temp = temp1.toChar() - temp2.toChar()
    il.text = "Ilość dni wyjazdu: "+temp.absoluteValue.toString()
}