package com.irfananda00.mac.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        btnSave.setOnClickListener { view ->
            val intent = intent
            val title = etTitle.text.toString()
            val desc = etDesc.text.toString()
            intent.putExtra("title", title)
            intent.putExtra("desc", desc)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}