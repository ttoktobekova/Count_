package com.example.count_.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelCounter : ViewModel() {
     val counterLiveData = MutableLiveData(0)

    fun increment() {
        counterLiveData.value = counterLiveData.value?.plus(1)
    }

    fun decrement() {
        counterLiveData.value = counterLiveData.value?.minus(1)
    }
}