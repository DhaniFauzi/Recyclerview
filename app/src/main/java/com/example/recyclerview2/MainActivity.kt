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
            Todo("Dhani","19090118", "Mobile", false ),
            Todo("Irpan", "19090099", "Mobile", false),
            Todo("Musnadil","19090033", "Mobile", false),
            Todo("Agung", "19090119", "Web", false),
            Todo("Fadil", "19090117", "Web", false),
            Todo("Ramdon", "19090116", "Web", false)

        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)

        binding.btnAddList.setOnClickListener{
            val tittle1 = binding.etAddList3.text.toString()
            val tittle2 = binding.etAddList2.text.toString()
            val tittle3 = binding.etAddList1.text.toString()
            val todo = Todo(tittle1, tittle2, tittle3, false)
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size)
        }
    }
}