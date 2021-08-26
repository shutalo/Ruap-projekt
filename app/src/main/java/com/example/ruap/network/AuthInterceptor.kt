package com.example.ruap.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    private val TAG = "AuthInterceptor"

    @Throws(Exception::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        var req = chain.request()

        try{
            if(req.url.toString().contains("azureml") ){
                Log.d(TAG,"authentication in progress")
                req = req.newBuilder().addHeader("Authorization","Bearer f/tvntQ5wvTY67zC3rTcFyU6OKP0j0SSeVw2S9nxIbctTC1HliTujsEzbgAkg/LvjuXLhZVq0J/kaWnbXUbaqg==").build()
            }
            // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
            val url = req.url.newBuilder().build()
            req = req.newBuilder().url(url).build()
            return chain.proceed(req)
        } catch (e: Exception){
            e.printStackTrace()
            e.message?.let { Log.d(TAG, it) }
        }

        return chain.proceed(req)

    }

}