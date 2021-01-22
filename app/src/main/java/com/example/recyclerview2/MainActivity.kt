package com.example.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.Adapter.TodoAdapter
import com.example.recyclerview2.databinding.ActivityMainBinding
import com.example.recyclerview2.model.Todo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Opening",false ),
            Todo("Penjelasan", false),
            Todo("RecycleView", false),
            Todo("Read the Rules", false),
            Todo("Praktek", false),
            Todo("Plugin", false)

        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)

        binding.btnAddList.setOnClickListener{
            val title = binding.etAddList.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size)
        }
    }
}