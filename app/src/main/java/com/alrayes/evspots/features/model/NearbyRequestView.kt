package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.NearbyRequest

data class NearbyRequestView(
    val location: String, val radius: Int,
    val type: String, val key: String
)

fun NearbyRequestView.toDomain() =
    NearbyRequest(
        location = this.location,
        radius = this.radius,
        type = this.type,
        key = this.key
    )
