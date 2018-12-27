package com.didar.extendedrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class EasyAdapter<T> private constructor(val layout: Int, val count: Int, val callback: Callback, var objects: List<T>)
    : RecyclerView.Adapter<EasyAdapter.Companion.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        callback.onBindViewHolder(p0, p0.itemView, p1)
    }

    override fun getItemCount(): Int {
        return count
    }

    fun updateDataSet(newDataSet: List<T>) {
        this.objects = newDataSet
        notifyDataSetChanged()
    }

    class Builder<T> {
        private var layout = 0
        private var count = 0
        private lateinit var items: List<T>
        private lateinit var callback: Callback

        fun setLayout(layout: Int): Builder<T> {
            this.layout = layout
            return this
        }

        fun setItemCount(count: Int): Builder<T> {
            this.count = count
            return this
        }

        fun setData(items: List<T>): Builder<T> {
            this.items = items
            return this
        }

        fun setCallback(callback: Callback): Builder<T> {
            this.callback = callback
            return this
        }

        fun build(): EasyAdapter<T> {
            return EasyAdapter(layout, count, callback, items)
        }
    }

    companion object {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}