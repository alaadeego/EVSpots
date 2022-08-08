package com.alrayes.remote.features.nearby.model


import com.alrayes.domain.features.nearby.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?
)

fun LocationDto.toDomain() = Location(
    lat = this.lat,
    lng = this.lng
)