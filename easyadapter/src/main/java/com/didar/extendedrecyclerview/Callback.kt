package com.didar.extendedrecyclerview

import android.view.View

interface Callback<T> {
    fun onBindViewHolder(viewHolder: EasyAdapter.Companion.ViewHolder, itemView: View, position: Int, item:T)
}