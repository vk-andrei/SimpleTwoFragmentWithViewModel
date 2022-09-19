package com.example.simpletwofragmentwithviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyDataModel : ViewModel() {

    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrag1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrag2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}