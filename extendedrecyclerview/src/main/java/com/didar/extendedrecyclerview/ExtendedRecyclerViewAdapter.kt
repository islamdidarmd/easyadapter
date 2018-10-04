package com.didar.extendedrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class ExtendedRecyclerViewAdapter(val layout: Int,
                                           var objects: List<Any>,
                                           val callback: Callback)
    : RecyclerView.Adapter<ExtendedRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    fun updateDataSet(newDataSet: List<Any>) {
        this.objects = newDataSet
        notifyDataSetChanged()
        callback.onDataSetChanged(objects.size, newDataSet)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                callback.onClick(adapterPosition, itemView, objects[adapterPosition])
            }

            itemView.setOnLongClickListener {
                callback.onLongClick(adapterPosition, itemView, objects[adapterPosition])
                return@setOnLongClickListener true
            }
        }
    }
}