package com.alrayes.di

import com.alrayes.domain.features.nearby.repository.NearbyRepository
import com.alrayes.remote.features.nearby.NearbyDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindNearbyRepository(nearbyDataRepository: NearbyDataRepository): NearbyRepository


}