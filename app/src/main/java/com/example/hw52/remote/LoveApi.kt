package com.example.hw52.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(@Query("fname") firstName: String,
                      @Query("sname") secondName: String,
                      @Header("X-RapidAPI-Key") key: String = "6ef4c32594mshbf1448717a0af9fp19a177jsn80c401e71ed0",
                      @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}