package com.example.ruap.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ruap.R
import com.example.ruap.network.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity() {

    private val TAG = "SplashActivity"

//    private val articlesViewModel by viewModel<ArticlesViewModel>()
    private val articlesViewModel = ArticlesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        articlesViewModel.newsFetched.observe(this){
            if(it != null){
                //tu bi trebo obradit te dohvacene clanke i poslat kroz fetchCategorized request na azure s tim podacima
                articlesViewModel.fetchCategorizedNews()
//                val intent: Intent = Intent(this,MainActivity::class.java)
//                intent.putExtra("size",it.size)
//                for(index in it.indices){
//                    intent.putExtra("article$index",it[index])
//                }
//                Log.d(TAG,it.toString())
//                startActivity(intent)
            }
        }

        articlesViewModel.fetchNews()

    }
}