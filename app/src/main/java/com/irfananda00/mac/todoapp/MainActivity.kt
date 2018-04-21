package com.irfananda00.mac.todoapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_TODO = 1
    val listTodo: MutableList<Todo> = ArrayList()
    lateinit var adapterTodo: AdapterTodo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "To Do"

        adapterTodo = AdapterTodo(this,listTodo)
        rv.adapter = adapterTodo
        rv.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == R.id.menubtn_add_todo){
            startActivityForResult(Intent(this, InputActivity::class.java), REQUEST_CODE_TODO)
            true
        }else
            super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_TODO){
            if (resultCode == Activity.RESULT_OK){
                if (data != null) {
                    val title = data.getStringExtra("title")
                    val desc = data.getStringExtra("desc")
                    listTodo.add(Todo(title, desc))
                    adapterTodo.notifyItemInserted(listTodo.size)
                }
            }
        }
    }
}
