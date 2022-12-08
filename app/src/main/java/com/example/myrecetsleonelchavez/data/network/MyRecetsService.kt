package com.example.myrecetsleonelchavez.data.network

import com.example.myrecetsleonelchavez.core.RetrofitH
import com.example.myrecetsleonelchavez.data.model.MyRecetsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRecetsService {

    private var retrofit = RetrofitH.getRetrofit()

    suspend fun getMyRecetsService():MyRecetsResponse{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MyRecetsApiClient::class.java).getMyRecetsApiClient()
            response
        }
    }
}