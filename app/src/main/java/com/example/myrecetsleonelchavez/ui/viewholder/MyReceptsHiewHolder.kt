package com.example.myrecetsleonelchavez.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.databinding.ItemRecetsBinding
import com.example.myrecetsleonelchavez.loadImg
import com.example.myrecetsleonelchavez.ui.adapter.MyReceptsAdapter

class MyReceptsHiewHolder(view : View, var listenerOnClick : MyReceptsAdapter.ClickMoreDescripcion): RecyclerView.ViewHolder(view) {

    private val binding = ItemRecetsBinding.bind(view)
    var myRecets = MyRecets()

    fun render(item: MyRecets){
        this.myRecets = item
        binding.txtNameFood.text = item.name
        binding.imgFood.loadImg(item.img_food!!)
        binding.rlIcon.setOnClickListener {
            listenerOnClick.onClick(myRecets)
        }
    }


}