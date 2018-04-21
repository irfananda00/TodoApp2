package com.irfananda00.mac.todoapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by mac on 4/21/18.
 */
class AdapterTodo(val context : Context, val listTodo : List<Todo>) : RecyclerView.Adapter<AdapterTodo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val item = listTodo[position]

        holder?.tvTitle?.text = item.title
        holder?.tvDesc?.text = item.desc
    }

    override fun getItemCount(): Int {
        return listTodo.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val tvTitle = item.findViewById<View>(R.id.tvTitle) as TextView
        val tvDesc = item.findViewById<View>(R.id.tvDesc) as TextView
    }
}