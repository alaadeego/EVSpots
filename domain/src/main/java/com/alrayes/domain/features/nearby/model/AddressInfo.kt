package com.alrayes.domain.features.nearby.model

data class AddressInfo(
    val addressLine1: String?,
    val contactEmail: String?,
    val description: String?,
    val distance: String?,
    val distanceUnit: Int?,
    val iD: Int?,
    val latitude: Double?,
    val longitude: Double?,
    val postcode: String?,
    val relatedURL: String?,
    val stateOrProvince: String?,
    val title: String?,
    val town: String?
)

