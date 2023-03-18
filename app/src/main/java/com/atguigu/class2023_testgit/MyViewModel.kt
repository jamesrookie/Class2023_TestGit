package com.atguigu.class2023_testgit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private val _number=MutableLiveData(0)
    val numberLiveData: LiveData<Int> get()=_number
    fun add(n:Int){
        _number.value= _number.value?.plus(1)
    }
    fun reset(){
        _number.value=0
    }
    var number=0
}