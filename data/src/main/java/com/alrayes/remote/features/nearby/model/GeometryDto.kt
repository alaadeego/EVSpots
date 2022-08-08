package com.alrayes.remote.features.nearby.model


import com.alrayes.domain.features.nearby.model.Geometry
import com.google.gson.annotations.SerializedName

data class GeometryDto(
    @SerializedName("location")
    val location: LocationDto?,
)

fun GeometryDto.toDomain() = Geometry(
    location = this.location?.toDomain()
)