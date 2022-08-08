package com.alrayes.remote.features.nearby.model


import com.alrayes.domain.features.nearby.model.Geometry
import com.alrayes.domain.features.nearby.model.Nearby
import com.google.gson.annotations.SerializedName

data class NearbyDto(
    @SerializedName("business_status")
    val businessStatus: String?,
    @SerializedName("geometry")
    val geometry: GeometryDto?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("icon_background_color")
    val iconBackgroundColor: String?,
    @SerializedName("icon_mask_base_uri")
    val iconMaskBaseUri: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("place_id")
    val placeId: String?,
    @SerializedName("price_level")
    val priceLevel: Int?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("reference")
    val reference: String?,
    @SerializedName("scope")
    val scope: String?,
    @SerializedName("types")
    val types: List<String>?,
    @SerializedName("user_ratings_total")
    val userRatingsTotal: Int?,
    @SerializedName("vicinity")
    val vicinity: String?
)

fun NearbyDto.toDomain() = Nearby(
    businessStatus = this.businessStatus,
    geometry = this.geometry?.toDomain(),
    icon = this.icon,
    iconBackgroundColor = this.iconBackgroundColor,
    iconMaskBaseUri = this.iconMaskBaseUri,
    name = this.name,
    placeId = this.placeId,
    priceLevel = this.priceLevel,
    rating = this.rating,
    reference = this.reference,
    scope = this.scope,
    types = this.types,
    userRatingsTotal = this.userRatingsTotal,
    vicinity = this.vicinity,

    )
