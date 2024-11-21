package com.example.count_

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.count_.databinding.ActivityMainBinding
import com.example.count_.model.ViewModelCounter

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[ViewModelCounter::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnDecrement.setOnClickListener {
                viewModel.decrement()
            }
            btnIncrement.setOnClickListener {
                viewModel.increment()
            }
        }

        viewModel.counterLiveData.observe(this) { count ->
            binding.tvResult.visibility = View.VISIBLE
            binding.tvResult.text = count.toString()
        }
    }
}