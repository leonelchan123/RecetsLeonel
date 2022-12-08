package com.example.myrecetsleonelchavez.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitH {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://demo5868885.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}