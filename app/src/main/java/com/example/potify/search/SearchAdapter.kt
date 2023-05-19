package com.example.potify.search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.PlayerFragmentDirections
import com.example.potify.R
import com.example.potify.databinding.ItemAlbumSearchBinding
import com.example.potify.databinding.ItemMusicSearchBinding
import com.example.potify.entities.Album
import com.example.potify.entities.Music
import java.util.Locale

class SearchAdapter(private val listener: OnFilteredListListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var dataList: List<Any> = emptyList()
    var filteredList = dataList
    private var parent0: ViewGroup? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        parent0 = parent
        val musicBinding =
            ItemMusicSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val albumBinding =
            ItemAlbumSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            VIEW_TYPE_MUSIC -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_music_search, parent, false)
                MusicViewHolder(musicBinding)
            }

            VIEW_TYPE_ALBUM -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_album_search, parent, false)
                AlbumViewHolder(albumBinding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    class MusicViewHolder(private val binding: ItemMusicSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Music) {
            Glide.with(binding.root).load(music.imageUrl).into(binding.musicImage)
            binding.musicName.text = music.title
            binding.artistName.text = "Song · " + music.artist
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

    class AlbumViewHolder(private val binding: ItemAlbumSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            Glide.with(binding.root).load(album.imageSrc).into(binding.albumImage)
            binding.albumName.text = album.name
            binding.artistName.text = "Album · " + album.artist
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = filteredList[position]
        when (holder.itemViewType) {
            VIEW_TYPE_MUSIC -> {
                val musicHolder = holder as MusicViewHolder
                val musicData = item as Music
                musicHolder.bind(musicData)
            }

            VIEW_TYPE_ALBUM -> {
                val albumHolder = holder as AlbumViewHolder
                val albumData = item as Album
                albumHolder.bind(albumData)
            }
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (filteredList[position]) {
            is Music -> VIEW_TYPE_MUSIC
            is Album -> VIEW_TYPE_ALBUM
            else -> throw IllegalArgumentException("Invalid data type")
        }
    }

    companion object {
        private const val VIEW_TYPE_MUSIC = 0
        private const val VIEW_TYPE_ALBUM = 1
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().lowercase(Locale.getDefault())
                val filteredData: List<Any>
                if (query.isEmpty()) {
                    filteredData = emptyList()
                } else {
                    filteredData = dataList.filter {
                        when (it) {
                            is Music -> {
                                it.title.plus(it.artist).lowercase(Locale.getDefault())
                                    .contains(query)
                            }

                            is Album -> {
                                it.name.plus(it.artist).lowercase(Locale.getDefault())
                                    .contains(query)
                            }

                            else -> {
                                throw IllegalArgumentException("Invalid data type")
                            }
                        }
                    }
                }
                val results = FilterResults()
                results.values = filteredData
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Any>
                notifyDataSetChanged()

                listener.onFilteredList(filteredList)
            }
        }
    }

    interface OnFilteredListListener {
        fun onFilteredList(filteredData: List<Any>)
    }
}
