package com.alrayes.domain.features.nearby.model

data class Nearby(
    val businessStatus: String?,
    val geometry: Geometry?,
    val icon: String?,
    val iconBackgroundColor: String?,
    val iconMaskBaseUri: String?,
    val name: String?,
    val placeId: String?,
    val priceLevel: Int?,
    val rating: Double?,
    val reference: String?,
    val scope: String?,
    val types: List<String>?,
    val userRatingsTotal: Int?,
    val vicinity: String?

)