package com.omerfarukcelik.launch.network

import com.omerfarukcelik.launch.model.Launch
import retrofit2.http.GET
import retrofit2.Call

interface LaunchService {

  @GET("/v2/launches")
  fun getLaunches(): Call<Launch>
}