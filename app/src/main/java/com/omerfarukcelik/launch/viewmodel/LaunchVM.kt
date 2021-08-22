package com.omerfarukcelik.launch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omerfarukcelik.launch.model.Launch
import com.omerfarukcelik.launch.repository.LaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchVM @Inject constructor(private val repository: LaunchRepository) : ViewModel() {

  var launches: MutableLiveData<Launch> = MutableLiveData()


  fun getLaunches() {
    repository.getLaunches(launches)
  }
}