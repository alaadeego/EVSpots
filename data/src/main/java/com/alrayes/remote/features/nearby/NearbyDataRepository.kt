package com.alrayes.remote.features.nearby

import com.alrayes.domain.features.nearby.model.Nearby
import com.alrayes.domain.features.nearby.model.NearbyRequest
import com.alrayes.domain.features.nearby.repository.NearbyRepository
import com.alrayes.remote.features.nearby.model.toDomain
import com.alrayes.remote.features.nearby.service.NearbyService
import javax.inject.Inject

class NearbyDataRepository @Inject constructor(
    private val nearbyService: NearbyService
) : NearbyRepository {

    override suspend fun getNearby(request: NearbyRequest): List<Nearby> {
        return nearbyService.getNearby(
            request.location,
            request.radius,
            request.type,
            request.key
        ).results.map { it.toDomain() }
    }
}