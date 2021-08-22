package com.omerfarukcelik.launch.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omerfarukcelik.launch.model.Launch
import com.omerfarukcelik.launch.network.LaunchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LaunchRepository @Inject constructor(private val launchService: LaunchService) {

  fun getLaunches(dataList: MutableLiveData<Launch>) {
    launchService.getLaunches().enqueue(object : Callback<Launch> {
      override fun onResponse(call: Call<Launch>, response: Response<Launch>) {
        if (response.isSuccessful && !response.body().isNullOrEmpty()) {
          dataList.postValue(response.body())
        }
      }

      override fun onFailure(call: Call<Launch>, t: Throwable) {
        t.localizedMessage?.toString()?.let { Log.e(t.message, it) }
      }

    })
  }
}