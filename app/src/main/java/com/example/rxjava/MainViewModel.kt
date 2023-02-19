package com.example.rxjava

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.rxjava.network.BasicAPIService
import com.example.rxjava.network.RxSingleSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(val apiService: BasicAPIService, val schedulers: RxSingleSchedulers) {
    /**
     * Livedata
     * Get the data
     *
     * OBSERVER -----> Subscribes -------> Observable(Single)
     */
    val users = MutableLiveData<List<ModelItem>>()
    val errorMsg = MutableLiveData<String>()
    @SuppressLint("CheckResult")
    fun fetchUsers(){
        apiService.getAllUsers()
            .subscribeOn(Schedulers.io())
            .compose(schedulers.applySchedulers())
            .subscribe(
                //Success
                //OnError
                { result -> users.postValue(result)},
                {throwable -> errorMsg.}
            )
    }
}