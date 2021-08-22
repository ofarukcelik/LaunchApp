package com.omerfarukcelik.launch.model

import java.io.Serializable

data class LaunchItem(
    val details: String,
    val launch_year: String,
    val links: Links,
    val mission_name: String,
    val rocket: Rocket
): Serializable