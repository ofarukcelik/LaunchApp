package com.omerfarukcelik.launch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omerfarukcelik.launch.R
import com.omerfarukcelik.launch.model.Launch
import com.omerfarukcelik.launch.model.LaunchItem

class LaunchListAdapter(var listener: ItemClickListener) :
  RecyclerView.Adapter<LaunchListAdapter.ViewHolder>() {

  private var dataList: Launch = Launch()

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txtMissionName: TextView = itemView.findViewById(R.id.txtMissionName)
    var txtYear: TextView = itemView.findViewById(R.id.txtYear)
    var imageView: ImageView = itemView.findViewById(R.id.imageView)
    fun bindItem(item: LaunchItem) {
      txtMissionName.text = item.mission_name
      txtYear.text = String.format("Yıl : %s", item.launch_year)
      Glide.with(imageView).load(item.links.mission_patch_small).into(imageView)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view =
      LayoutInflater.from(parent.context).inflate(R.layout.launch_list_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItem(dataList[position])
    holder.itemView.setOnClickListener {
      listener.onItemClick(dataList[position])
    }
  }

  override fun getItemCount(): Int {
    return dataList.size
  }

  fun setItems(items: Launch) {
    dataList = items
    notifyDataSetChanged()
  }

  interface ItemClickListener {
    fun onItemClick(selectedLaunch: LaunchItem)
  }
}