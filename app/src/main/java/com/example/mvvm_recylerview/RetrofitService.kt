package com.example.mvvm_recylerview

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("v1/8703cae8-f5f2-4682-9bd7-dfcc9eb2e861")
    fun getAllMovies(): Call<List<Airways>>


    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://mocki.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(HttpClient.getUnsafeOkHttpClient()!!.build())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}