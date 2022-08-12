package com.alrayes.domain.features.nearby.repository

import com.alrayes.domain.features.nearby.model.AddressInfo
import com.alrayes.domain.features.nearby.model.Nearby
import com.alrayes.domain.features.nearby.model.NearbyRequest

interface NearbyRepository {

    suspend fun getNearby(request : NearbyRequest):List<Nearby>
}