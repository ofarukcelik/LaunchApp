package com.omerfarukcelik.launch.di

import com.omerfarukcelik.launch.network.LaunchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  val BASE_URL = "https://api.spacexdata.com"

  @Singleton
  @Provides
  fun provideLaunchService(): LaunchService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(LaunchService::class.java)
}