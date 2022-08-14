package com.alrayes.evspots.features

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.alrayes.evspots.databinding.ActivityMainBinding
import com.alrayes.evspots.features.adapter.SpotsAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val spotsAdapter = SpotsAdapter()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private val viewModel: MainViewModel by viewModels()
    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
                Log.wtf("ACCESS_FINE_LOCATION", "ACCESS_FINE_LOCATION")
                getLocation()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                // Only approximate location access granted.
                Log.wtf("ACCESS_COARSE_LOCATION", "ACCESS_COARSE_LOCATION")
                getLocation()
            }
            else -> {
                // No location access granted.
                Log.wtf("No location access granted", "No location access granted")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        initObservers()
        viewModel.fetchNearbySpots()

        if (hasLocationPermission()) {
            getLocation()
        } else
            requestLocationPermission()


    }

    private fun initUi() {
        binding.mainRecyclerview.apply {
            adapter = spotsAdapter
        }
    }

    private fun initObservers() {
        viewModel.nearbySpots
            .flowWithLifecycle(lifecycle, Lifecycle.State.CREATED)
            .filterNotNull()
            .onEach { nearbySports ->
                spotsAdapter.setItems(nearbySports)
                Log.wtf("SpotsResults", "${nearbySports}")
            }.launchIn(lifecycleScope)

    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        /*
        val locationRequest =  LocationRequest.create().apply {
            interval = 100
            fastestInterval = 50
            priority = Priority.PRIORITY_HIGH_ACCURACY
            maxWaitTime = 100
        }
         */
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // Got last known location. In some rare situations this can be null.
                Log.wtf("location", " lat: ${location?.latitude}   log ${location?.longitude} ")

            }
    }

    private fun requestLocationPermission() {
        Log.wtf("hasStoragePermission", "false")

        if (!hasLocationPermission()) {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private fun hasLocationPermission() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED


}