package com.omerfarukcelik.launch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.omerfarukcelik.launch.R
import com.omerfarukcelik.launch.databinding.ActivityDetailBinding
import com.omerfarukcelik.launch.model.LaunchItem

class DetailActivity : AppCompatActivity() {
  lateinit var binding: ActivityDetailBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val launch = intent.getSerializableExtra("selectedLaunch") as LaunchItem
    setItems(launch)
    binding.icClose.setOnClickListener {
      finish()
    }
  }

  private fun setItems(launchItem: LaunchItem) {
    binding.txtMissionName.text = launchItem.mission_name
    binding.txtMissionDetail.text = launchItem.details
    binding.txtRocketName.text = String.format("Rocket Name: %s", launchItem.rocket.rocket_name)
    binding.txtRocketType.text = String.format("Rocket Type: %s", launchItem.rocket.rocket_type)
    binding.txtLaunchYear.text = String.format("Year: %s", launchItem.launch_year)
    Glide.with(applicationContext).load(launchItem.links.mission_patch_small).into(binding.icLaunch)
  }
}