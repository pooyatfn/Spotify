package com.example.potify.library.song

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.PlayerFragmentDirections
import com.example.potify.databinding.ItemMusicSearchBinding
import com.example.potify.entities.Music
import java.util.Locale

class SongAdapter(private val listener: OnFilteredListListener) :
    RecyclerView.Adapter<SongAdapter.ViewHolder>(), Filterable {

    var dataList: List<Music> = emptyList()
    var filteredList = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMusicSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemMusicSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(music: Music) {
            Glide.with(binding.root).load(music.imageUrl).into(binding.musicImage)
            binding.musicName.text = music.title
            binding.artistName.text = music.artist
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredList[position]
        holder.bind(item)
    }

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().lowercase(Locale.getDefault())
                val filteredData: List<Music> = if (query.isEmpty()) {
                    emptyList()
                } else {
                    dataList.filter {
                        it.title.plus(it.artist).lowercase(Locale.getDefault()).contains(query)
                    }
                }
                val results = FilterResults()
                results.values = filteredData
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Music>
                notifyDataSetChanged()

                listener.onFilteredList(filteredList)
            }
        }
    }

    interface OnFilteredListListener {
        fun onFilteredList(filteredData: List<Music>)
    }
}
