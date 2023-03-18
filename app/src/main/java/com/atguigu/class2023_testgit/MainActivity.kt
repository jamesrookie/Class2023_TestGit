package com.atguigu.class2023_testgit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.atguigu.class2023_testgit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var myViewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModel=ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.number=savedInstanceState?.getInt("NUMBER")?:0
        binding.tvNumber.text="${myViewModel.number}"

        binding.btnAdd.setOnClickListener {
            binding.tvNumber.text="${++myViewModel.number}"
        }
        binding.btnSubtract.setOnClickListener {
            binding.tvNumber.text="${--myViewModel.number}"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("NUMBER",myViewModel.number)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menuReset){
            myViewModel.number=0
            binding.tvNumber.text="${myViewModel.number}"
        }
        return super.onOptionsItemSelected(item)
    }
}