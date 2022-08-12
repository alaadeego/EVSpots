package com.alrayes.domain.features.nearby.model

data class NearbyRequest(
    val latitude: Double?,
    val longitude: Double?,
    val maxResults: Int
)
