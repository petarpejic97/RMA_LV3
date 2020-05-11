package com.example.drugizadatak


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextUtils
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }
    private fun setUpUi() {
        viewPager.adapter = HandsomeAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}
