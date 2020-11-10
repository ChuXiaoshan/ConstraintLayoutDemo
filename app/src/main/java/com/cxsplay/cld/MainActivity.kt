package com.cxsplay.cld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cxsplay.cld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        bind.btnMotion1.setOnClickListener { startActivity(Intent(this, Motion1Activity::class.java)) }
        bind.btnMotion2.setOnClickListener { startActivity(Intent(this, Motion2Activity::class.java)) }
        bind.btnMotion3.setOnClickListener { startActivity(Intent(this, Motion3Activity::class.java)) }
        bind.btnLayout1.setOnClickListener { startActivity(Intent(this, Layout1Activity::class.java)) }
        bind.btnLayout2.setOnClickListener { startActivity(Intent(this, Layout1Activity::class.java)) }
        bind.btnLayout3.setOnClickListener { startActivity(Intent(this, Layout1Activity::class.java)) }
    }
}