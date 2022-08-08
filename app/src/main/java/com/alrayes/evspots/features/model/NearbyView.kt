package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.Geometry
import com.alrayes.domain.features.nearby.model.Nearby

data class NearbyView(
    val businessStatus: String?,
    val geometry: GeometryView?,
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

fun Nearby.toView() = NearbyView(
 businessStatus = this.businessStatus ,
 geometry = this.geometry?.toView() ,
 icon = this.icon ,
 iconBackgroundColor = this.iconBackgroundColor ,
 iconMaskBaseUri = this.iconMaskBaseUri ,
 name = this.name ,
 placeId = this.placeId ,
 priceLevel = this.priceLevel ,
 rating = this.rating ,
 reference = this.reference ,
 scope = this.scope ,
 types = this.types ,
 userRatingsTotal = this.userRatingsTotal ,
 vicinity = this.vicinity ,
)
