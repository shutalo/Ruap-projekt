package com.example.ruap.network

import com.example.ruap.data.processed.request.Request
import com.example.ruap.data.processed.response.AzureResponse
import com.example.ruap.data.unprocessed.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AzureApi {
    @POST("411a1d5afdf84c42b01dea227d375de6/services/3bb7bd2191a545a583a553ec0272587d/execute?api-version=2.0&details=true")
    suspend fun fetchCategorizedNews(@Body request: Request): AzureResponse

}