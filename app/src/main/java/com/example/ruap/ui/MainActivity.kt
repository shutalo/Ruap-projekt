package com.example.ruap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ruap.R
import com.example.ruap.data.Article
import com.example.ruap.databinding.ActivityMainBinding
import com.example.ruap.ui.adapters.ArticlesRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val articles: MutableList<Article> = mutableListOf()

        val size = intent.getIntExtra("size",-1)
        if(size != -1){
            for(index in 0 until size){
                articles.add(intent.getSerializableExtra("article$index") as Article)
            }
        }

        Log.d(TAG,articles.toString())


        val articleListFragment: ArticlesListFragment = ArticlesListFragment()
        val args = Bundle()
        args.putInt("size",articles.size)
        for(index in articles.indices){
            args.putSerializable("article$index",articles[index])
        }
        articleListFragment.arguments = args

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,articleListFragment).commit()
    }
}