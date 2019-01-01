package com.didar.extendedrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class EasyAdapter<T> private constructor(private val layout: Int, private val callback: Callback<T>, private var objects: List<T>)
    : RecyclerView.Adapter<EasyAdapter.Companion.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        callback.onBindViewHolder(p0, p0.itemView, p1, objects[p1])
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    fun updateDataSet(newDataSet: List<T>) {
        this.objects = newDataSet
        notifyDataSetChanged()
    }

    class Builder<T> {
        private var layout = 0
        private lateinit var items: List<T>
        private lateinit var callback: Callback<T>

        fun setLayout(layout: Int): Builder<T> {
            this.layout = layout
            return this
        }

        fun setData(items: List<T>): Builder<T> {
            this.items = items
            return this
        }

        fun setCallback(callback: Callback<T>): Builder<T> {
            this.callback = callback
            return this
        }

        fun build(): EasyAdapter<T> {
            return EasyAdapter(layout, callback, items)
        }
    }

    companion object {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    }
}