package com.example.potify.library.album

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.databinding.ItemAlbumSearchBinding
import com.example.potify.entities.Album
import java.util.Locale

class AlbumAdapter(private val listener: OnFilteredListListener) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>(), Filterable {

    var dataList: List<Album> = emptyList()
    var filteredList = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAlbumSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemAlbumSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            Glide.with(binding.root).load(album.imageSrc).into(binding.albumImage)
            binding.albumName.text = album.name
            binding.artistName.text = album.artist
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
                val filteredData: List<Album> = if (query.isEmpty()) {
                    emptyList()
                } else {
                    dataList.filter {
                        it.name.plus(it.artist).lowercase(Locale.getDefault()).contains(query)
                    }
                }
                val results = FilterResults()
                results.values = filteredData
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Album>
                notifyDataSetChanged()

                listener.onFilteredList(filteredList)
            }
        }
    }

    interface OnFilteredListListener {
        fun onFilteredList(filteredData: List<Album>)
    }
}
