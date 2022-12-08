package com.example.myrecetsleonelchavez.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.databinding.ActivitySummaryRecetsBinding
import com.example.myrecetsleonelchavez.loadImg
import com.example.myrecetsleonelchavez.toJson
import com.google.gson.Gson

/**
 * Leonel chavez
 */

class DetailsRecetsActivity : AppCompatActivity() {

    var recets: String? = ""
    var recetsL: MyRecets? = null

    lateinit var binding: ActivitySummaryRecetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryRecetsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        val extras = intent.extras
        if (extras != null) {
            recets = extras.getString("recets")
            recetsL = Gson().fromJson(recets,MyRecets::class.java)
        }

        binding.txtTool.text = "Detalle de ${recetsL!!.name}"

        binding.imgBack.setOnClickListener {
            onBackPressed()
        }

        binding.imgFood.loadImg(recetsL?.img_food!!)
        binding.txtName.text = recetsL!!.name
        binding.txtDescriptionFood.text = recetsL!!.description
        binding.txtPreparationFood.text = recetsL!!.preparation_food
        binding.txtIngredientsFood.text = recetsL!!.ingredients_food

        binding.btnMap.setOnClickListener {
            val goMap = Intent(this@DetailsRecetsActivity, FoodMapActivity::class.java)
            goMap.putExtra("recets", toJson(recetsL))
            startActivity(goMap)

        }
    }

}