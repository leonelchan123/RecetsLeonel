package com.example.myrecetsleonelchavez.data.model


data class MyRecetsResponse (
    var foods: MutableList<MyRecets?> = mutableListOf(),
    var status: String? = null
)