package com.example.hw52.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.hw52.remote.LoveApi
import dagger.Binds
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        Log.e("shh", "аппмодул")
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(LoveApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
    }
}