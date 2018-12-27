package com.didar.extendedrecyclerview

import android.view.View

interface Callback {
    fun onBindViewHolder(viewHolder: EasyAdapter.Companion.ViewHolder, itemView: View, position: Int)
}