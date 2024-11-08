package com.example.count_.model

interface CounterView {
    fun showResult(count:Int)
    fun showBg(color:Int)
    fun showToast(message:String)
}