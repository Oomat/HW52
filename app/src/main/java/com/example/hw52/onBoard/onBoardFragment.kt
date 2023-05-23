package com.example.hw52.onBoard

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.hw52.LoveActivity
import com.example.hw52.R
import com.example.hw52.databinding.FragmentOnBoardBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class onBoardFragment : Fragment() {

    lateinit var binding: FragmentOnBoardBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkBoarding()
    }

    private fun checkBoarding() {
        if (sharedPreferences.getBoolean("isFirst", false)){
            val intent = Intent(requireActivity(), LoveActivity::class.java)
            startActivity(intent)
        } else {
            initViews()
        }
    }

    private fun initViews() {
        val adapter = BoardingAdapter(childFragmentManager)
        binding.vp.adapter = adapter

    }
}