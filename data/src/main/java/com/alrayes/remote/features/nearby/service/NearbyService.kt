package com.alrayes.remote.features.nearby.service

import com.alrayes.remote.features.nearby.model.AddressInfoDto
import com.alrayes.remote.features.nearby.model.NearbyDto
import com.alrayes.remote.features.nearby.model.NearbyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NearbyService {
    @GET("poi")
    suspend fun getNearby(
        @Query("key") key: String,
        @Query("latitude") latitude: Double? ,
        @Query("longitude") longitude: Double?,
        @Query("maxresults") maxResults: Int,

    ): List<NearbyDto>

}