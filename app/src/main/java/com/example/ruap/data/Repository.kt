package com.example.ruap.data

import android.util.Log
import com.example.ruap.data.processed.request.Request
import com.example.ruap.data.processed.response.AzureResponse
import com.example.ruap.data.processed.response.Value
import com.example.ruap.network.AzureApi
import com.example.ruap.network.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit

class Repository(private val newsApi: NewsApi, private val azureApi: AzureApi) {

    private val TAG = "Repository"

    suspend fun fetchNews(): Flow<MutableList<Article>> = flow {
        try {
            val response = newsApi.fetchNews()
            if(response.status != "ok"){
                Log.d(TAG,response.status)
            }
            Log.d(TAG,response.totalResults.toString())
            Log.d(TAG,response.articles.toString())
            emit(response.articles)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    suspend fun fetchCategorizedNews(request: Request): Flow<List<List<String>>> = flow {
        try {
            val response = azureApi.fetchCategorizedNews(request)
//            if(response.status != "ok"){
//                Log.d(TAG,response.status)
//            }
//            Log.d(TAG,response.totalResults.toString())
//            Log.d(TAG,response.articles.toString())
            emit(response.Results.output1.value.Values)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }
}