package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.NearbyRequest

data class NearbyRequestView(
    val latitude: Double?= null ,
    val longitude: Double?= null ,
    val maxResults: Int
)

fun NearbyRequestView.toDomain() =
    NearbyRequest(
        latitude = this.latitude,
        longitude = this.longitude,
        maxResults = this.maxResults,
    )
