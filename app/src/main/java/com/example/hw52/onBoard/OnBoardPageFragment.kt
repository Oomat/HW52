package com.example.hw52.onBoard

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.hw52.LoveActivity
import com.example.hw52.LoveViewModel
import com.example.hw52.databinding.FragmentOnBoardPageBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardPageFragment : Fragment() {

    lateinit var binding: FragmentOnBoardPageBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initClickers()
    }

    private fun initClickers() {
        binding.btnStart.setOnClickListener {
            viewModel.isSecondBoarding()
            val intent = Intent(requireActivity(), LoveActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        val data = arguments?.getSerializable("onBoard") as BoardModel
        data.image?.let { binding.ivIc.setImageResource(it) }
        binding.tvDesc.text = data.title
        binding.btnStart.isVisible = data.isLast == true
    }
}