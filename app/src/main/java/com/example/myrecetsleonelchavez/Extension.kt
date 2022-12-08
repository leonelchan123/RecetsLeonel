package com.example.myrecetsleonelchavez

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.gson.Gson

fun ImageView.loadImg(url: String) {
    this.load(url) {
        placeholder(R.drawable.logo_restaurant)
        error(R.drawable.logo_restaurant)
        transformations(RoundedCornersTransformation(20f))
    }
}

fun toJson(clazz: Any?): String {
    val gson = Gson()
    return gson.toJson(clazz)
}