package com.didar.extendedrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class EasySectionedAdapter<T> private constructor(private val headerLayout: Int,
                                                  private val childLayout: Int,
                                                  private val callback: SectionedCallback<T>,
                                                  private var objects: List<List<T>>) : RecyclerView.Adapter<EasyAdapter.Companion.ViewHolder>() {

    override fun getItemCount(): Int {
        var count = 0
        objects.forEach {
            count += it.size
        }
        return count + objects.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_HEADER

        var count = 1
        objects.forEach {
            count += it.size
            if (count == position) return TYPE_HEADER
            count++
        }

        return TYPE_CHILD
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): EasyAdapter.Companion.ViewHolder {
        return if (getItemViewType(p1) == TYPE_HEADER) {
            EasyAdapter.Companion.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(headerLayout, viewGroup, false))
        } else {
            EasyAdapter.Companion.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(childLayout, viewGroup, false))
        }
    }

    override fun onBindViewHolder(p0: EasyAdapter.Companion.ViewHolder, p1: Int) {
        val section = getSection(p1)

        if (getItemViewType(p1) == TYPE_HEADER) {
            callback.onBindHeader(p0, section)
        } else {
            val relativePosition = getRelativePosition(section, p1)
            callback.onBindChild(p0, section, relativePosition, p1, objects[section][relativePosition])
        }
    }

    private fun getSection(position: Int): Int {
        var section = 0
        var count = 1

        objects.forEach {
            count += it.size
            if (count > position) return section
            count++
            section++
        }
        return section
    }

    private fun getRelativePosition(section: Int, position: Int): Int {
        if (section == 0) return position - 1

        var count = 1
        for (x in 0 until section) {
            count += objects[x].size
            count++
        }

        return position - count
    }

    fun updateDataSet(newDataSet: List<List<T>>) {
        this.objects = newDataSet
        notifyDataSetChanged()
    }


    private val TYPE_HEADER = 0
    private val TYPE_CHILD = 1

    class Builder<T> {
        private var headerLayout = 0
        private var childLayout = 0
        private lateinit var items: List<List<T>>
        private lateinit var callback: SectionedCallback<T>

        fun setHeaderLayout(layout: Int): Builder<T> {
            this.headerLayout = layout
            return this
        }

        fun setChildLayout(layout: Int): Builder<T> {
            this.childLayout = layout
            return this
        }

        fun setDataSet(items: List<List<T>>): Builder<T> {
            this.items = items
            return this
        }

        fun setCallback(callback: SectionedCallback<T>): Builder<T> {
            this.callback = callback
            return this
        }

        fun build(): EasySectionedAdapter<T> {
            return EasySectionedAdapter(headerLayout, childLayout, callback, items)
        }
    }
}

