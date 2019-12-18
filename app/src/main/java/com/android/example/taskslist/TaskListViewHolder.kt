package com.android.example.taskslist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    val listPosition: TextView = itemView.findViewById(R.id.task_number_item)

    val listText: TextView = itemView.findViewById(R.id.task_text_item)
}