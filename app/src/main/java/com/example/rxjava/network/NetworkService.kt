package com.example.rxjava.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createBasicRetrofitService(): BasicAPIService{
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //to provide data to recyclerview adapter
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .build()

    return retrofit.create(BasicAPIService::class.java)


}