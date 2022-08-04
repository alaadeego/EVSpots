package com.alrayes.evspots.features

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alrayes.evspots.R
import com.alrayes.evspots.base.BaseApplication
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
/*
    @Inject
    lateinit var someRandomeString: String
    @Inject
    lateinit var app: BaseApplication

 */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // Log.d(TAG, "onCreate :${someRandomeString}")
        //Log.d(TAG, "onCreate :${app}")
    }
}