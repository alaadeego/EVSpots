package com.alrayes.domain.features.nearby.model

data class NearbyRequest(
    val location: String, val radius: Int,
    val type: String, val key: String
)
