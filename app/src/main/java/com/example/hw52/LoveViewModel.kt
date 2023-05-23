package com.example.hw52

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw52.remote.LoveModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class LoveViewModel @Inject constructor(
    private val repository: Repository,
    private val preferences: SharedPreferences
) : ViewModel() {

    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
    fun isSecondBoarding(){
        preferences.edit().putBoolean("isFirst", true).apply()
    }

}