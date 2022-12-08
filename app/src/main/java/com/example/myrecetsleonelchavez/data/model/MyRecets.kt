package com.example.myrecetsleonelchavez.data.model

data class MyRecets(
    var name: String? = null,
    var description: String? = null,
    var preparation_food: String? = null,
    var ingredients_food: String? = null,
    var img_food: String? = null,
    var food_lat: Double? = null,
    var food_lng: Double? = null

)