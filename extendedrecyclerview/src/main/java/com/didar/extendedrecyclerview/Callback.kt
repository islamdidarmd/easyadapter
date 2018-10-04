package com.didar.mylibrary

import android.view.View

interface Callback {
    fun onClick(position: Int, view: View, item: Any)

    fun onLongClick(position: Int, view: View, item: Any)

    fun onDataSetChanged(newDataSetSize: Int, newDataSet: List<Any>)
}