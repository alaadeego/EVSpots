package com.alrayes.evspots.features.model

import com.alrayes.domain.features.nearby.model.Nearby

data class NearbyView(
    val addressInfo: AddressInfoView
)

fun Nearby.toView() = NearbyView(
    addressInfo = this.addressInfo.toView()
)
