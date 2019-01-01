package com.didar.extendedrecyclerview

interface SectionedCallback<T> {
    fun onBindHeader(viewHolder: EasyAdapter.Companion.ViewHolder, section: Int)

    fun onBindChild(viewHolder: EasyAdapter.Companion.ViewHolder, section: Int, positionInSection: Int, position:Int, item:T)
}