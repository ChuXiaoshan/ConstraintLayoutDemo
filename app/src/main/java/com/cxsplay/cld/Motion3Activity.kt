package com.cxsplay.cld

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.cxsplay.cld.databinding.ActivityMotion3Binding

class Motion3Activity : AppCompatActivity() {

    private lateinit var bind: ActivityMotion3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_motion3)
        init()
    }

    private fun init() {
        bind.vp.adapter = MyPageAdapter()

        bind.vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val numPages = 5
                bind.ml.progress = (position + positionOffset) / (numPages - 1)
            }
        })
    }

    class MyPageAdapter : RecyclerView.Adapter<MyPageAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pager, parent, false))
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tvName?.text = "pager $position"
        }

        override fun getItemCount() = 5

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var tvName: TextView? = null

            init {
                tvName = itemView.findViewById(R.id.tv_name)
            }
        }
    }
}