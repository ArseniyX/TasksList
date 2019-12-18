package com.android.example.taskslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskListRecyclerViewAdapter(private val tasks: ArrayList<TaskList>) :
    RecyclerView.Adapter<TaskListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.task_list_item,
                parent,
                false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {

        holder.listPosition.text = (position + 1).toString()

        holder.listText.text = tasks[position].name
    }

    fun addList(task: TaskList) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

}
