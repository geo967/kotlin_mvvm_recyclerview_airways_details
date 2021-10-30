package com.example.mvvm_recylerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Airways>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Airways>> {
            override fun onResponse(call: Call<List<Airways>>, response: Response<List<Airways>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Airways>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}


