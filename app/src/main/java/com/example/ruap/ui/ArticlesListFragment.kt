package com.example.ruap.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ruap.R
import com.example.ruap.data.Article
import com.example.ruap.databinding.FragmentArticleBinding
import com.example.ruap.databinding.FragmentArticlesListBinding
import com.example.ruap.ui.adapters.ArticlesRecyclerViewAdapter
import com.example.ruap.ui.adapters.CategoryRecyclerViewAdapter
//import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ArticlesListFragment : Fragment(), ArticlesRecyclerViewAdapter.OnArticleClickListener, CategoryRecyclerViewAdapter.OnCategoryClickListener {

    private val TAG = "ArticlesListFragment"

    private lateinit var binding: FragmentArticlesListBinding
    private val articlesViewModel = ArticlesViewModel()
//    private val viewModel by sharedViewModel<ArticlesViewModel>()
    private val categories = mutableListOf<String>("Entertainment","Politics","Crime","Sport","Business","Tech","Money","Science","Media")
    private var articles = mutableListOf<Article>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticlesListBinding.inflate(layoutInflater)

        val size = arguments?.getInt("size",-1)
        if(size != -1 && size != null){
            articles = mutableListOf()
            for(index in 0 until size){
                articles.add(arguments?.getSerializable("article$index") as Article)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpUi()
    }

    override fun onCategoryClick(position: Int) {
        val newArticles = mutableListOf<Article>()
        articles.forEach {
            if(categories[position].lowercase(Locale.getDefault()) == it.category){
                newArticles.add(it)
            }
        }
        (binding.articlesRv.adapter as ArticlesRecyclerViewAdapter).refreshData(newArticles,categories[position].lowercase(Locale.getDefault()))
    }


    private fun setUpUi(){
        binding.articlesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.articlesRv.adapter = ArticlesRecyclerViewAdapter(this)
        binding.articlesRv.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        val newArticles = mutableListOf<Article>()
        articles.forEach {
            if(it.category == "entertainment"){
                newArticles.add(it)
            }
        }
        (binding.articlesRv.adapter as ArticlesRecyclerViewAdapter).refreshData(newArticles)
        binding.categoriesRv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRv.adapter = CategoryRecyclerViewAdapter(this,categories)
        binding.categoriesRv.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.HORIZONTAL))
    }

    override fun onArticleClicked(position: Int) {
        val args = Bundle()
        val f = ArticleFragment()
        args.putString("title", articles[position].title)
        args.putString("content", articles[position].content)
        f.arguments = args
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container,f).addToBackStack(TAG).commit()
    }


}