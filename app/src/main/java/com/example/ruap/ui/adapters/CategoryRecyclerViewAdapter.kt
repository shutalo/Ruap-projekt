package com.example.ruap.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ruap.R
import com.example.ruap.data.Article

class CategoryRecyclerViewAdapter(private val listener: CategoryRecyclerViewAdapter.OnItemClickListener, private var categories: MutableList<String>) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val categoryTv: TextView = itemView.findViewById<TextView>(R.id.category)

        fun bind(category: String){
            categoryTv.text = category
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }
    }

    fun refreshData(){

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}