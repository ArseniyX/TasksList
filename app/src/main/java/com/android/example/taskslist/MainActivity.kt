package com.android.example.taskslist

import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val taskDataManager = TaskDataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val tasks = taskDataManager.readList()

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TaskListRecyclerViewAdapter(tasks)

        fab.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {

        val titleDialog = getString(R.string.add_task_dialog_title)

        val buttonName = getString(R.string.add_task_button_name)

        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_TEXT

        AlertDialog.Builder(this).apply {

            setTitle(titleDialog)

            setView(editText)

            setPositiveButton(buttonName) { dialog, _ ->

                val task = TaskList(editText.text.toString())

                val recyclerViewAdapter = recyclerView.adapter
                        as TaskListRecyclerViewAdapter

                recyclerViewAdapter.addList(task)

                dialog.dismiss()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
