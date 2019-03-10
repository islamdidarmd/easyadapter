package com.didar.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.didar.extendedrecyclerview.Callback
import com.didar.extendedrecyclerview.EasyAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.row_list.view.*
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "RecyclerView"
        setContentView(R.layout.activity_recycler_view)

        val list: MutableList<Int> = ArrayList()

        (1..50).forEach { i ->
            list.add(i)
        }

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.adapter = EasyAdapter.Builder<Int>()
                .setLayout(R.layout.row_list)
                .setData(list)
                .setCallback(object : Callback<Int> {
                    override fun onBindViewHolder(viewHolder: EasyAdapter.Companion.ViewHolder, itemView: View, position: Int, item: Int) {
                        val tv: TextView = viewHolder.itemView.textView
                        tv.text = item.toString()
                    }
                })
                .build()
    }
}
