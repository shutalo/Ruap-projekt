package com.example.ruap.network

import com.example.ruap.data.unprocessed.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?sources=bbc-news,abc-news,breitbart-news,cbc-news,cnn,google-news,fox-news,independent,national-review,nbc-news,news24&apiKey=8b5b704ff29c4515916a05155b8773e1")
    suspend fun fetchNews(): Response

}