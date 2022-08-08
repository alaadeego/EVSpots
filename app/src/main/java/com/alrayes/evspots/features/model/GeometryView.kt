package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.Geometry

data class GeometryView(
    val location: LocationView?,
)

fun Geometry.toView() = GeometryView(
    location = location?.toView()
)
