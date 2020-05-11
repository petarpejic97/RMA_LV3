package com.example.drugizadatak


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextUtils
import android.util.Log
import com.example.drugizadatak.Fragments.OnLongTouchListener


class MainActivity : AppCompatActivity() {
    private var onLongTouch : OnLongTouchListener?= null

    fun setOnUpdating(c : OnLongTouchListener){
        Log.w("USAO", "setto sam activiti")
        onLongTouch = c
    }

    fun getUpdataId(id : Int){
        Log.w("USAO", "USAO $id")
        onLongTouch?.setFieldsForUpdate(id)
        viewPager.currentItem=1
    }
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
