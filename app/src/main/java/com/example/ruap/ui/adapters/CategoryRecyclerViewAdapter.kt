package com.example.ruap.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ruap.MyApp
import com.example.ruap.R
import com.example.ruap.data.Article
import java.util.*

class CategoryRecyclerViewAdapter(private val listener: CategoryRecyclerViewAdapter.OnCategoryClickListener, private var categories: MutableList<String>) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {

    private var categorySelected: String = "entertainment"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        if(categorySelected == categories[position].lowercase(Locale.getDefault())){
            holder.bind(categories[position],ContextCompat.getColor(MyApp.context,R.color.category_highlight))
        } else {
            holder.bind(categories[position],ContextCompat.getColor(MyApp.context,R.color.category))
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val categoryTv: TextView = itemView.findViewById<TextView>(R.id.category)

        fun bind(category: String, color: Int){
            categoryTv.text = category
            categoryTv.setBackgroundColor(color)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onCategoryClick(position)
                categorySelected = categories[position].lowercase(Locale.getDefault())
                notifyDataSetChanged()
            }
        }
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(position: Int)
    }
}