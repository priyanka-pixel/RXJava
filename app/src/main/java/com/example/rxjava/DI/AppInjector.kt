package com.example.rxjava.DI

import com.example.rxjava.MainViewModel
import com.example.rxjava.network.RxSingleSchedulers
import com.example.rxjava.network.createBasicRetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module{
       single { createBasicRetrofitService() }
    single{RxSingleSchedulers.DEFAULT}
}
val viewModelModule = module {
   viewModel{
    MainViewModel(get(), get())
}
}