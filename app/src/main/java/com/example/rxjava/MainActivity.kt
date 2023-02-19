package com.example.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Inject viewmodel: Hilt = = Koin
 */
class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.users.observe(this, Observer{
            Log.i("Data",it.get(0).title)
        })
    }
}