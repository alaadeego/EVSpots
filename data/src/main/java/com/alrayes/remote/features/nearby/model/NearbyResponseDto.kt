package com.alrayes.remote.features.nearby.model


import com.google.gson.annotations.SerializedName

data class NearbyResponseDto(
    @SerializedName("Example Results")
    val results: List<NearbyDto>,
)

