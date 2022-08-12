package com.alrayes.remote.features.nearby.model


import com.alrayes.domain.features.nearby.model.Nearby
import com.google.gson.annotations.SerializedName

data class NearbyDto(
    @SerializedName("AddressInfo")
    val addressInfo: AddressInfoDto,
)
fun NearbyDto.toDomain() = Nearby(
addressInfo = this.addressInfo.toDomain()
)