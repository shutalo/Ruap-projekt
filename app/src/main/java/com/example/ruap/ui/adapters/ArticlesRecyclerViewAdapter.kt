package com.example.ruap.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ruap.R
import com.example.ruap.data.Article

class ArticlesRecyclerViewAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ArticleViewHolder>() {

    private var articles: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener {

        private val articleTitle: TextView = itemView.findViewById<TextView>(R.id.title)
        private val articleContent: TextView = itemView.findViewById<TextView>(R.id.content)

        fun bind(article: Article){
            articleTitle.text = article.title
            articleContent.text = article.description
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

    fun refreshData(articles: MutableList<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}