package com.example.myrecetsleonelchavez.ui.activities

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrecetsleonelchavez.R
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.databinding.ActivityFoodMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.gson.Gson

/**
 * Leonel chavez
 */

class FoodMapActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var binding: ActivityFoodMapBinding
    var reciveRecets = ""
    var recetsL: MyRecets? = null
    lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MapsInitializer.initialize(applicationContext)
        init()
        initMap()
    }

    @SuppressLint("SetTextI18n")
    fun init() {
        val extras = intent.extras
        if (extras != null) {
            reciveRecets = extras.getString("recets").toString()
            recetsL = Gson().fromJson(reciveRecets, MyRecets::class.java)
        }
        binding.imgBack.setOnClickListener { onBackPressed() }
        binding.txtTool.text = "Ubicación de ${recetsL!!.name}"
    }


    private fun initMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }


    private fun initMarket() {
        val latAndLng =
            recetsL!!.food_lat?.let { recetsL!!.food_lng?.let { it1 -> LatLng(it, it1) } }
        val market = latAndLng?.let { MarkerOptions().position(it).title(recetsL!!.name) }
        map.addMarker(market)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latAndLng, 18f), 1000, null)
    }

    override fun onMapReady(gmaps: GoogleMap) {
        map = gmaps
        map.uiSettings.isZoomControlsEnabled = true
        map.stopAnimation()
        initMarket()
    }


}