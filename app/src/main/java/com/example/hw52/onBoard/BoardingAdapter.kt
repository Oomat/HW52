package com.example.hw52.onBoard

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hw52.R

class BoardingAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val listBoarding = arrayOf(
        BoardModel(
            R.drawable.ic_1,
            "It's fun and Many more",
            false
        ),
        BoardModel(
            R.drawable.ic_2,
            "Have a good time" + "\n" +
                    "You should take the time to help those " + "\n" +
                    "who need you",
            false
        ),
        BoardModel(
            R.drawable.ic_3,
            "Cherishing love" + "\n" +
                    "It is now longer possible for" + "\n" +
                    "you to cherish love",
            false
        ),
        BoardModel(
            R.drawable.ic_4,
            "Have a breakup?" + "\n" +
                    "We have made the correction for you" + "\n" +
                    "don't worry " + "\n" +
                    "Maybe someone is waiting for you!",
            true
        )
    )

    override fun getCount(): Int {
        return listBoarding.size
    }

    override fun getItem(position: Int): Fragment {
        val data = bundleOf("onBoard" to listBoarding[position])
        val fragment = OnBoardPageFragment()
        fragment.arguments = data
        return fragment
    }
}