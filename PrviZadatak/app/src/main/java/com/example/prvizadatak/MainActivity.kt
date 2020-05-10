package com.example.prvizadatak

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }
    override fun onResume() {
        super.onResume()
        displayNumber()
    }
    private fun setUpUi() {
        greenColor.setOnClickListener{saveColorAndIncrement("GR")}
        greyColor.setOnClickListener{saveColorAndIncrement("GY")}
        blueColor.setOnClickListener{saveColorAndIncrement("BL")}
        brownColor.setOnClickListener{saveColorAndIncrement("BR")}
        reset.setOnClickListener{resetCounterAndColor()}
    }
    private fun saveColorAndIncrement(colorLetter : String){
        saveColor(colorLetter)
        incrementNumber()
    }
    private fun resetCounterAndColor(){
        saveNumber(0.toString())
        birdCounter.setBackgroundColor(Color.TRANSPARENT)
    }

    private fun setColor(color:String){
        if(color == "GR") {
            birdCounter.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        }
        else if (color == "GY") {
            birdCounter.setBackgroundColor(resources.getColor(R.color.colorGray))
        }
        else if (color == "BR") {
            birdCounter.setBackgroundColor(resources.getColor(R.color.colorBrown))
        }
        else if (color == "BL") {
            birdCounter.setBackgroundColor(resources.getColor(R.color.colorBlue))
        }
    }
    private fun incrementNumber() {
        var counter: String = birdCounter.text.toString()
        var counterNumber = counter.toInt()
        counterNumber += 1
        saveNumber(counterNumber.toString())
    }

    private fun saveNumber(counter : String){
        val preferenceManager = PreferenceManager()
        preferenceManager.saveCounter(counter)
        displayNumber()
    }
    private fun saveColor(color : String){
        val preferenceManager = PreferenceManager()
        preferenceManager.saveColor(color)
    }
    private fun displayNumber() {
        val counter = PreferenceManager().retrieveCounter()
        birdCounter.text =  counter
        val color = PreferenceManager().retrieveColor()
        color?.let { setColor(it) }
    }
}
