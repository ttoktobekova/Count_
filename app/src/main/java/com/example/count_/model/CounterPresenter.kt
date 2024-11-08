package com.example.count_.model

import android.content.Context
import androidx.core.content.ContextCompat.getColor
import com.example.count_.R

class CounterPresenter {
    private val model = CounterModel()
    private var counterView: CounterView? = null
    private var context: Context? = null
    private var isGreenBgShown = false


    fun onIncrement() {
        model.increment()
        check()
        counterView?.showResult(model.getResult())
    }

    fun onDecrement() {
        model.decrement()
        check()
        counterView?.showResult(model.getResult())
    }

    private fun check() {
        val count = model.getResult()
        when (count) {
            10 -> counterView?.showToast("Поздравляю")
            15 -> {
                if (!isGreenBgShown) {
                    context?.let {
                        val greenColor = getColor(it, R.color.green)
                        counterView?.showBg(greenColor)
                    }
                    isGreenBgShown = true
                }
            }

            else -> {
                if (isGreenBgShown) {
                    context?.let {
                        val originalColor = getColor(it, R.color.white)
                        counterView?.showBg(originalColor)
                    }
                    isGreenBgShown = false
                }

            }
        }
    }

    fun attachCountCountView(counterView: CounterView, context: Context) {
        this.counterView = counterView
        this.context = context
        counterView.showResult(model.getResult())
    }


    fun detachCountView() {
        this.counterView = null
    }
}
