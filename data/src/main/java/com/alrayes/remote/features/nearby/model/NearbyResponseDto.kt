package com.alrayes.remote.features.nearby.model


import com.google.gson.annotations.SerializedName

data class NearbyResponseDto(
    @SerializedName("results")
    val results: List<NearbyDto>,
    @SerializedName("status")
    val status: String?
)