package com.example.simpletwofragmentwithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.simpletwofragmentwithviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mDataModel: MyDataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(FragmentOne.newInstance(), R.id.fl_container_one)
        openFrag(FragmentTwo.newInstance(), R.id.fl_container_two)

        // Наблюдает за изменением MESSAGE
        mDataModel.messageForActivity.observe(this) {
            binding.tvMainActivity.text = it
        }
    }

    private fun openFrag(f: Fragment, container: Int) {
        supportFragmentManager.beginTransaction()
            .replace(container, f)
            .commit()
    }
}