package com.example.ruap.network

import com.example.ruap.data.unprocessed.Response
import retrofit2.http.POST

interface AzureApi {
    @POST("411a1d5afdf84c42b01dea227d375de6/services/3ffd82a72bae4401957c0e62aba15eb3/execute?api-version=2.0&details=true")
    suspend fun fetchCategorizedNews():

}