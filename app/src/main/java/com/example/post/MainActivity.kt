package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
        sendData()
    }

    private fun sendData() {
        viewModel.postModel().observe(this, Observer {
            when(it.status){
                Status.SUCCESS ->{
                    Log.d("Response Data", it.data.toString())
                }
                Status.ERROR ->{
                    Log.d("Response erroe", it.message.toString())
                }
                Status.LOADING ->{
                    Log.d("Loading Data", it.message.toString())
                }
            }
        })
    }
}