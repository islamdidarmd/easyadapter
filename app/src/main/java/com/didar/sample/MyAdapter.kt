package com.didar.sample

import com.didar.extendedrecyclerview.Callback
import com.didar.extendedrecyclerview.ExtendedRecyclerViewAdapter
import kotlinx.android.synthetic.main.row_list.view.*

class MyAdapter(layout: Int, internal var list: List<Int>, callback: Callback) :
        ExtendedRecyclerViewAdapter(layout, list, callback) {

    override fun onBindViewHolder(viewHolder: ExtendedRecyclerViewAdapter.ViewHolder, i: Int) {
        viewHolder.itemView.textView.text = list[i].toString()
    }
}
