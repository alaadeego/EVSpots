package com.alrayes.remote.features.nearby.model


import com.alrayes.domain.features.nearby.model.AddressInfo
import com.google.gson.annotations.SerializedName

data class AddressInfoDto(
    @SerializedName("AddressLine1")
    val addressLine1: String?,
    @SerializedName("ContactEmail")
    val contactEmail: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("Distance")
    val distance: String?,
    @SerializedName("DistanceUnit")
    val distanceUnit: Int?,
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("Latitude")
    val latitude: Double?,
    @SerializedName("Longitude")
    val longitude: Double?,
    @SerializedName("Postcode")
    val postcode: String?,
    @SerializedName("RelatedURL")
    val relatedURL: String?,
    @SerializedName("StateOrProvince")
    val stateOrProvince: String?,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Town")
    val town: String?
)

fun AddressInfoDto.toDomain() = AddressInfo(
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