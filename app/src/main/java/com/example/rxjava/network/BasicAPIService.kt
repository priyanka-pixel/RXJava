package com.example.rxjava.network

import com.example.rxjava.ModelItem
import io.reactivex.Single
import retrofit2.http.GET

interface BasicAPIService {
    //RXJava
    //Coroutine
    //@GET("public/")
    //suspend fun getalllists
    @GET("posts")
    fun getAllUsers(): Single<List<ModelItem>>
}