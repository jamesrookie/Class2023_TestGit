package com.atguigu.class2023_testgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.atguigu.class2023_testgit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var number:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        number=savedInstanceState?.getInt("NUMBER")?:0
        binding.tvNumber.text="$number"

        binding.btnAdd.setOnClickListener {
            binding.tvNumber.text="${++number}"
        }
        binding.btnSubtract.setOnClickListener {
            binding.tvNumber.text="${--number}"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("NUMBER",number)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menuReset){
            number=0
            binding.tvNumber.text="$number"
        }
        return super.onOptionsItemSelected(item)
    }
}