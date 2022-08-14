package com.alrayes.evspots.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alrayes.evspots.databinding.SpotItemBinding
import com.alrayes.evspots.features.model.NearbyView

class SpotsAdapter : Adapter<SpotsAdapter.SpotItemViewHolder>() {
    private var items: List<NearbyView> = emptyList()

    inner class SpotItemViewHolder(private val binding: SpotItemBinding) :
        ViewHolder(binding.root) {

        fun bind(nearbyView: NearbyView) {
            binding.titleTV.text = nearbyView.addressInfo.title
            binding.addressLineTV.text = nearbyView.addressInfo.addressLine1
            binding.townTV.text = nearbyView.addressInfo.town
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotItemViewHolder {
        val binding = SpotItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpotItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpotItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount()= items.size


    fun setItems(items: List<NearbyView>) {
        this.items = items
        notifyDataSetChanged()
    }
}