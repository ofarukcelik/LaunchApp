package com.omerfarukcelik.launch.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.omerfarukcelik.launch.adapter.LaunchListAdapter
import com.omerfarukcelik.launch.databinding.ActivityMainBinding
import com.omerfarukcelik.launch.model.LaunchItem
import com.omerfarukcelik.launch.viewmodel.LaunchVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LaunchListAdapter.ItemClickListener {
  lateinit var binding: ActivityMainBinding
  lateinit var adapter: LaunchListAdapter
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    initRecylerView()
    initVM()
  }

  private fun initVM() {
    val viewModel = ViewModelProvider(this)[LaunchVM::class.java]
    viewModel.getLaunches()
    viewModel.launches.observe(this, {
      if (!it.isNullOrEmpty()) {
        adapter.setItems(it)
      }
    })
  }

  private fun initRecylerView() {
    binding.recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
    adapter = LaunchListAdapter(this)
    binding.recyclerView.adapter = adapter
  }

  override fun onItemClick(selectedLaunch: LaunchItem) {
    val intent = Intent(applicationContext, DetailActivity::class.java)
    intent.putExtra("selectedLaunch", selectedLaunch )
    startActivity(intent)
  }

}