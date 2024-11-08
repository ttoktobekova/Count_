package com.example.count_

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.count_.databinding.ActivityMainBinding
import com.example.count_.model.CounterPresenter
import com.example.count_.model.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    private val presenter = CounterPresenter()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachCountCountView(this, this)
        binding.apply {
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }
        }
    }

    override fun showResult(count: Int) {
        binding.tvResult.visibility = View.VISIBLE
        binding.tvResult.text = count.toString()
    }

    override fun showBg(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachCountView()
    }
}