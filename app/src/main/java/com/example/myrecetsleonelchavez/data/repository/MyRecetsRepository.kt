package com.example.myrecetsleonelchavez.data.repository

import com.example.myrecetsleonelchavez.data.model.MyRecetsResponse
import com.example.myrecetsleonelchavez.data.network.MyRecetsService

class MyRecetsRepository {

    private var api = MyRecetsService()

    suspend fun getMyRecetsRepository(): MyRecetsResponse{
        val response = api.getMyRecetsService()
        return response
    }
}