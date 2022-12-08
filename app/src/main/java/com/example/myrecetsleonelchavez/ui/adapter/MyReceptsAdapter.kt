package com.example.myrecetsleonelchavez.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecetsleonelchavez.R
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.ui.viewholder.MyReceptsHiewHolder

class MyReceptsAdapter(var myRecets: MutableList<MyRecets?>, var listenerOnClick : ClickMoreDescripcion): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyReceptsHiewHolder(
            layoutInflater.inflate(
                R.layout.item_recets, parent, false
            ),listenerOnClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myRecetsVH = myRecets[position]
        if (holder is MyReceptsHiewHolder){
            holder.render(myRecetsVH!!)
        }
    }

    override fun getItemCount(): Int {
        return myRecets.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterItems(myRecetsFilter: MutableList<MyRecets?>){
        this.myRecets = myRecetsFilter
        notifyDataSetChanged()
    }

    interface ClickMoreDescripcion{
        fun onClick(myRecets: MyRecets)
    }
}