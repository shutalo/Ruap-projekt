package com.example.ruap.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoryRecyclerViewAdapter : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

//        fun bind(player: User, position: Int){
//            itemView.player_name.text = player.username.toString()
//            itemView.player_high_score.text = player.highScore.toString()
//            itemView.position.text = (position + 4).toString()
//        }
    }

    fun refreshData(){

    }
}