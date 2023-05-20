package com.example.potify.home.goodAfternoon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.PlayerFragmentDirections
import com.example.potify.databinding.ItemGoodAfternoonBinding
import com.example.potify.entities.Music

class GoodAfternoonAdapter : RecyclerView.Adapter<GoodAfternoonAdapter.ViewHolder>() {

    var musics: List<Music> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGoodAfternoonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = musics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val good = musics[position]
        holder.bind(good)
    }

    inner class ViewHolder(private val binding: ItemGoodAfternoonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(music: Music) {
            Glide.with(binding.root).load(music.imageUrl).into(binding.goodImage)
            binding.goodText.text = music.title
            binding.root.setOnClickListener { view ->
                val songTitle = music.title
                val artistName = music.artist
                val imageUrl = music.imageUrl
                val songUrl = music.trackUrl

                val action = PlayerFragmentDirections.actionGlobalPlayerFragment(
                    songTitle, artistName, songUrl, imageUrl
                )
                view.findNavController().navigate(action)
            }
        }
    }
}