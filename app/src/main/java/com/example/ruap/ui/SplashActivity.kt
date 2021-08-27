package com.example.ruap.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ruap.R
import com.example.ruap.data.processed.request.Input1
import com.example.ruap.data.processed.request.Inputs
import com.example.ruap.data.processed.request.Request
import com.example.ruap.network.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"

//    private val articlesViewModel by viewModel<ArticlesViewModel>()
//    private val articlesViewModel by inject()
    private val articlesViewModel = ArticlesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()


        articlesViewModel.newsFetched.observe(this){
            if(it != null){
                val values = mutableListOf<MutableList<String>>()
                val columnNames = mutableListOf<String>()
                columnNames.add("category")
                columnNames.add("headline")
                for(index in it.indices){
                    val headline = mutableListOf<String>()
                    headline.add("entertainment")
                    headline.add(it[index].title)
                    values.add(headline)
                }
                val globalParameters: HashMap<String,String> = hashMapOf()
                globalParameters["Remove stop words"] = ""
                val request = Request(Inputs(Input1(columnNames,values)), globalParameters)

                articlesViewModel.fetchCategorizedNews(request)

            }
        }

        articlesViewModel.categorizedNewsFetched.observe(this){
            val articles = articlesViewModel.newsFetched.value
            if(it != null){
                for(index in it.indices){
                    articles?.get(index)?.category = it[index][0]
                }
                  val intent: Intent = Intent(this,MainActivity::class.java)
                intent.putExtra("size",it.size)
                for(index in it.indices){
                    intent.putExtra("article$index",articles?.get(index))
                }
                articles?.toString()?.let { it1 -> Log.d(TAG, it1) }
                startActivity(intent)
            }
        }

        articlesViewModel.fetchNews()

    }
}