package com.example.simpletwofragmentwithviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.simpletwofragmentwithviewmodel.databinding.ActivityMainBinding
import com.example.simpletwofragmentwithviewmodel.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private val mDataModel: MyDataModel by activityViewModels()
    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentOne().apply {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSentToFrag2.setOnClickListener {
            mDataModel.messageForFrag2.value = "Hello from Frag 1"
        }
        binding.btnSentToActivity.setOnClickListener {
            mDataModel.messageForActivity.value = "Hello activity, from Frag 1"
        }

        // Наблюдалка:
        mDataModel.messageForFrag1.observe(activity as LifecycleOwner) {
            binding.tvFragOne.text = it
        }
    }
}
