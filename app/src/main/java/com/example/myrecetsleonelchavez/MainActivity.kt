package com.example.myrecetsleonelchavez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.databinding.ActivityMainBinding
import com.example.myrecetsleonelchavez.ui.adapter.MyReceptsAdapter
import com.example.myrecetsleonelchavez.ui.activities.DetailsRecetsActivity
import com.example.myrecetsleonelchavez.ui.viewmodel.MyReceptsViewModel

/**
 * Leonel chavez
 */

class MainActivity : AppCompatActivity(), MyReceptsAdapter.ClickMoreDescripcion {
    lateinit var binding: ActivityMainBinding

    private val myRecetsViewModel: MyReceptsViewModel by viewModels()

    lateinit var adapter: MyReceptsAdapter

    var myRecets: MutableList<MyRecets?> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MyReceptsAdapter(mutableListOf(), this)
        initRecycler()
        filter()
        myRecetsViewModel.getMyRecetsVM()

    }

    fun initRecycler() {

        myRecetsViewModel.myRecetsViewModel.observe(this, Observer {
            if (it!!.size > 0) {
                adapter = MyReceptsAdapter(it, this)
                binding.rvFoods.layoutManager = LinearLayoutManager(this)
                binding.rvFoods.adapter = adapter
                binding.rvFoods.setHasFixedSize(true)
                myRecets = it
            }
        })
    }

    private fun filter() {
        binding.txtInputLayout.addTextChangedListener {

            val foodFiltered = myRecets.filter { name ->
                name!!.name!!.lowercase().contains(it.toString().lowercase())
            }
            if (foodFiltered.isEmpty()) {
                binding.nodata.visibility = View.VISIBLE
            } else {
                binding.nodata.visibility = View.GONE
            }
            adapter.filterItems(foodFiltered as MutableList<MyRecets?>)
        }
    }


    override fun onClick(myRecets: MyRecets) {
        val goAct = Intent(this, DetailsRecetsActivity::class.java)
        goAct.putExtra("recets", toJson(myRecets))
        startActivity(goAct)
    }


}