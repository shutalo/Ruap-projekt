package com.example.ruap.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ruap.R
import com.example.ruap.data.Article
import com.example.ruap.databinding.FragmentArticleBinding
import com.example.ruap.databinding.FragmentArticlesListBinding
import com.example.ruap.ui.adapters.ArticlesRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticlesListFragment : Fragment(), ArticlesRecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentArticlesListBinding
    private val articlesViewModel = ArticlesViewModel()
//    private val viewModel by sharedViewModel<ArticlesViewModel>()
    private val categories = mutableListOf<String>("Entertainment","Politics","Travel","World News","Media","Crime","Comedy","Latino Voices","Queer Voices","Religion","Sports","Impact","Business","Tech","Black Voices")
    private var articles = mutableListOf<Article>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArticlesListBinding.inflate(layoutInflater)

        val size = arguments?.getInt("size",-1)
        if(size != -1 && size != null){
            for(index in 0 until size){
                articles.add(arguments?.getSerializable("article$index") as Article)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.articlesRv.adapter = ArticlesRecyclerViewAdapter(this)

//        viewModel.categorizedNewsFetched.observe(viewLifecycleOwner){
//            (binding.articlesRv.adapter as ArticlesRecyclerViewAdapter).refreshData(it)
//        }
    }

    override fun onItemClick(position: Int) {
//        val args = Bundle()
//        val f = ArticleFragment()
//        args.putString("title", viewModel.categorizedNewsFetched.value?.get(position)?.title)
//        args.putString("content", viewModel.categorizedNewsFetched.value?.get(position)?.content)
//        f.arguments = args
//        parentFragmentManager.beginTransaction().replace(R.id.fragment_container,f).commit()
    }

}