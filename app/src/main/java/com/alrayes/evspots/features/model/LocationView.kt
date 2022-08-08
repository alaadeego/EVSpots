package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.Location

data class LocationView(
    val lat: Double?,
    val lng: Double?
)

fun Location.toView() = LocationView(
    lat = this.lat,
    lng  = this.lng
)
