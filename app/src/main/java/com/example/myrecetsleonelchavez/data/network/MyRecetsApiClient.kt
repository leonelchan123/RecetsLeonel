package com.example.myrecetsleonelchavez.data.network

import com.example.myrecetsleonelchavez.data.model.MyRecetsResponse
import retrofit2.http.GET

interface MyRecetsApiClient {

    @GET("main/foods")
    suspend fun getMyRecetsApiClient(): MyRecetsResponse

}