package com.alrayes.evspots.features

import androidx.activity.viewModels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alrayes.evspots.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
/*
    @Inject
    lateinit var someRandomeString: String
    @Inject
    lateinit var app: BaseApplication

 */

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchNearbySpots()

        // Log.d(TAG, "onCreate :${someRandomeString}")
        //Log.d(TAG, "onCreate :${app}")
    }
}