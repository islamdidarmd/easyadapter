package com.didar.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_general.setOnClickListener { startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java)) }

        btn_sectioned.setOnClickListener { startActivity(Intent(this@MainActivity, SectionedRecyclerViewActivity::class.java)) }
    }
}
