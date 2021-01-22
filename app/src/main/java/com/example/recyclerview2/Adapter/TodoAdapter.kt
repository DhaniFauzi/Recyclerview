package com.example.recyclerview2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.R
import com.example.recyclerview2.model.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter (var todos: List<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent,false))

    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTittle.text = todos[position].tittle
            cb_Done.isChecked = todos[position].isChecked
        }
    }

}