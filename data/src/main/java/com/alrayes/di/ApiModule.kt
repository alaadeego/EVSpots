package com.alrayes.di

import com.alrayes.remote.features.nearby.service.NearbyService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideReviewsService(
        @Named("base.url") baseUrl: String,
        gson: Gson
    ): NearbyService = provideRetrofit(baseUrl, gson)
        .create(NearbyService::class.java)


    @Provides
    @Named("base.url")
    fun provideBaseURL(): String = Constants.baseUrl

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    private fun provideRetrofit(baseUrl: String, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    private fun provideOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        httpClientBuilder.addInterceptor(loggingInterceptor)
        return httpClientBuilder.build()
    }


}
