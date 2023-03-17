package com.atguigu.class2023_testgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atguigu.class2023_testgit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var number:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            binding.tvNumber.text="${++number}"
        }
        binding.btnSubtract.setOnClickListener {
            binding.tvNumber.text="${--number}"
        }
    }
}