package com.cxsplay.cld

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
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
        bind.btn3.setOnClickListener { changeConstraint() }
        bind.btnMotion.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MotionActivity::class.java
                )
            )
        }
    }

    /**
     * 动态改变约束
     */
    private fun changeConstraint() {
        bind.cl3.let {
            val set = ConstraintSet()
            set.clone(it)
            set.clear(R.id.btn_2, ConstraintSet.START)
            set.clear(R.id.btn_2, ConstraintSet.BOTTOM)
            set.connect(R.id.btn_2, ConstraintSet.END, R.id.btn_3, ConstraintSet.START)
            set.applyTo(it)
        }
    }
}