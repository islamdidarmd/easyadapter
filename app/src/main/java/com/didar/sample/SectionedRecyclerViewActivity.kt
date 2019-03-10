package com.didar.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

import com.didar.extendedrecyclerview.EasyAdapter
import com.didar.extendedrecyclerview.EasySectionedAdapter
import com.didar.extendedrecyclerview.SectionedCallback
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.row_header.view.*

import org.jetbrains.annotations.NotNull

import java.util.ArrayList
import java.util.Arrays
import java.util.List

class SectionedRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Sectioned RecyclerView"
        setContentView(R.layout.activity_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()

        recyclerView.adapter = EasySectionedAdapter.Builder<Int>()
                .setHeaderLayout(R.layout.row_header)
                .setChildLayout(R.layout.row_list)
                .setDataSet(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2), Arrays.asList(1, 2, 3)))
                .setCallback(object : SectionedCallback<Int> {
                    override fun onBindHeader(viewHolder: EasyAdapter.Companion.ViewHolder, section: Int) {
                        viewHolder.itemView.setBackgroundColor(Color.BLACK)
                        val tv = viewHolder.itemView.textView
                        tv.setTextColor(Color.WHITE)
                        tv.text = "Header for section $section"
                    }

                    override fun onBindChild(viewHolder: EasyAdapter.Companion.ViewHolder, section: Int, positionInSection: Int, position: Int, item: Int) {
                        val tv = viewHolder.itemView.textView
                        tv.text = item.toString()
                        tv.setTextColor(Color.BLACK)
                        viewHolder.itemView.setBackgroundColor(Color.WHITE)
                    }
                })
                .build()
    }
}
