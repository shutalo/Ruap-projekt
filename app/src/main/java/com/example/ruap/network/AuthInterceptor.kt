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
                req = req.newBuilder().addHeader("Authorization","Bearer yG1dE9wD/UuzxVR//P4VGMQwGK2iSBB0NR4znUBjoV3MNNhbrLfLjBMHutJ6XwAFpp40WaLVKwpYnBgokQ++0Q==").build()
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