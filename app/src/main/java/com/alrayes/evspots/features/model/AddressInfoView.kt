package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.AddressInfo

data class AddressInfoView(
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

fun AddressInfo.toView() = AddressInfoView(
    addressLine1 = this.addressLine1,
    contactEmail = this.contactEmail,
    description = this.description,
    distance = this.distance,
    distanceUnit = this.distanceUnit,
    iD = this.iD,
    latitude = this.latitude,
    longitude = this.longitude,
    postcode = this.postcode,
    relatedURL = this.relatedURL,
    stateOrProvince = this.stateOrProvince,
    title = this.title,
    town = this.town,
)
