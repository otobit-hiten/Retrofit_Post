package com.example.post

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
     val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getInstance() :Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory
            .create())
            .build()
    }

    val apiService :ApiInterface? = getInstance().create(ApiInterface::class.java)
}