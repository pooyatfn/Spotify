package com.example.potify.home.recentlyPlayed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.R
import com.example.potify.databinding.RecentlyPlayedItemBinding
import com.example.potify.entities.Music

class RecentlyPlayedAdapter : RecyclerView.Adapter<RecentlyPlayedAdapter.ViewHolder>() {

    var musics: List<Music> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecentlyPlayedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = musics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recently = musics[position]
        holder.bind(recently)
    }

    inner class ViewHolder(private val binding: RecentlyPlayedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(music: Music) {
            Glide.with(binding.root)
                .load(music.imageSrc)
                .into(binding.recentlyImage)
            binding.recentlyText.text = music.name
            binding.root.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_global_playerFragment)
            }
        }
    }
}