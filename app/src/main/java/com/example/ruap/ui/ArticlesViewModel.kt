package com.example.ruap.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ruap.data.Repository
import androidx.lifecycle.viewModelScope
import com.example.ruap.data.Article
import com.example.ruap.network.AuthInterceptor
import com.example.ruap.network.AzureApi
import com.example.ruap.network.NewsApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticlesViewModel(/*private val repository: Repository*/) : ViewModel(){

    private val TAG = "ArticlesViewModel"

    private var _newsFetched: MutableLiveData<MutableList<Article>?> = MutableLiveData(null)
    var newsFetched: LiveData<MutableList<Article>?> = _newsFetched
    private var _categorizedNewsFetched: MutableLiveData<MutableList<Article>?> = MutableLiveData(null)
    var categorizedNewsFetched: LiveData<MutableList<Article>?> = _categorizedNewsFetched

    private lateinit var repository: Repository

    init {
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        val retrofit1 = Retrofit.Builder().baseUrl("https://newsapi.org/v2/").client(
            OkHttpClient().newBuilder().addInterceptor(logging).build())
            .addConverterFactory(GsonConverterFactory.create()).build()

        val newsApi = retrofit1.create(NewsApi::class.java)

        val retrofit2 = Retrofit.Builder().baseUrl("https://ussouthcentral.services.azureml.net/workspaces/").client(
            OkHttpClient().newBuilder().addInterceptor(AuthInterceptor()).addInterceptor(logging).build())
            .addConverterFactory(GsonConverterFactory.create()).build()

        val azureApi = retrofit1.create(AzureApi::class.java)


        repository = Repository(newsApi,azureApi)
    }


    fun fetchNews(){
        viewModelScope.launch {
            repository.fetchNews().collect{
                Log.d(TAG,it.toString())
                _newsFetched.postValue(it)
            }
        }
    }

    fun fetchCategorizedNews(){
        viewModelScope.launch {
//            repository.fetchCategorizedNews().collect{
//                Log.d(TAG,it.toString())
//                _categorizedNewsFetched.postValue(it)
//            }
        }
    }

}