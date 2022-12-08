package com.example.myrecetsleonelchavez.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecetsleonelchavez.data.model.MyRecets
import com.example.myrecetsleonelchavez.data.repository.MyRecetsRepository
import kotlinx.coroutines.launch

class MyReceptsViewModel: ViewModel() {

    private var myRecetsRepository  = MyRecetsRepository()
    var myRecetsViewModel = MutableLiveData<MutableList<MyRecets?>?>()
    var myRecetsViewModelResult = MutableLiveData<String>()

    fun getMyRecetsVM(){
        viewModelScope.launch {
            val res = myRecetsRepository.getMyRecetsRepository()
            when (res.status){
                "OK" -> { myRecetsViewModel.value = res.foods }
                else -> { myRecetsViewModelResult.value = "Error" }
            }

        }
    }
}