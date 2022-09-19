package com.example.simpletwofragmentwithviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.simpletwofragmentwithviewmodel.databinding.FragmentOneBinding
import com.example.simpletwofragmentwithviewmodel.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {
    private val mDataModel: MyDataModel by activityViewModels()
    lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentTwo().apply {
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSentToFrag1.setOnClickListener {
            mDataModel.messageForFrag1.value = "Hello from Frag 2"
        }
        binding.btnSentToActivity.setOnClickListener {
            mDataModel.messageForActivity.value = "Hello activity, from Frag 2"
        }

        // Наблюдалка:
        mDataModel.messageForFrag2.observe(activity as LifecycleOwner) {
            binding.tvFragTwo.text = it
        }


    }
}
