package com.cxsplay.cld

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.cxsplay.cld.databinding.ActivityLayout1Binding

class Layout1Activity : AppCompatActivity() {

    private lateinit var bind: ActivityLayout1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_layout1)
        init()
    }

    private fun init() {
        bind.btn1.setOnClickListener { changeConstraint(0) }
        bind.btn3.setOnClickListener { changeConstraint(1) }
    }

    /**
     * 动态改变约束 flag: 0 左边，1 右边
     */
    private fun changeConstraint(flag: Int) {
        bind.cl3.let {
            val set = ConstraintSet()
            set.clone(it)
            set.clear(R.id.btn_2, ConstraintSet.END)
            set.clear(R.id.btn_2, ConstraintSet.START)
            set.clear(R.id.btn_2, ConstraintSet.BOTTOM)
            if (flag == 0) {
                set.setMargin(R.id.btn_2, ConstraintSet.START, dp2px(10f))
                set.connect(R.id.btn_2, ConstraintSet.START, R.id.btn_1, ConstraintSet.END)
                set.connect(R.id.btn_2, ConstraintSet.BOTTOM, R.id.btn_1, ConstraintSet.BOTTOM)
            } else {
                set.setMargin(R.id.btn_2, ConstraintSet.END, dp2px(10f))
                set.connect(R.id.btn_2, ConstraintSet.END, R.id.btn_3, ConstraintSet.START)
                set.connect(R.id.btn_2, ConstraintSet.BOTTOM, R.id.btn_3, ConstraintSet.BOTTOM)
            }
            set.applyTo(it)
        }
    }

    private fun dp2px(dpValue: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().displayMetrics).toInt()
    }
}