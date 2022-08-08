package com.alrayes.domain.features.nearby.interactor

import com.alrayes.domain.base.UseCase
import com.alrayes.domain.features.nearby.model.Nearby
import com.alrayes.domain.features.nearby.model.NearbyRequest
import com.alrayes.domain.features.nearby.repository.NearbyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetNearby @Inject constructor(
    private val nearbyRepository: NearbyRepository,
     coroutineDispatcher: CoroutineDispatcher
) : UseCase<NearbyRequest, Flow<List<Nearby>>>(coroutineDispatcher) {
    public override suspend fun execute(input: NearbyRequest): Flow<List<Nearby>> = flow {
        emit(nearbyRepository.getNearby(input))
    }
}