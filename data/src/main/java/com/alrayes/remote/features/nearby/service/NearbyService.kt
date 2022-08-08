package com.alrayes.remote.features.nearby.service

import com.alrayes.remote.features.nearby.model.NearbyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NearbyService {
    @GET("place/nearbysearch/json")
    suspend fun getNearby(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String,
        @Query("key") key: String
    ): NearbyResponseDto

}