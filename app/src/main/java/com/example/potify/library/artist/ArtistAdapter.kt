package com.example.potify.library.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.databinding.ItemArtistSearchBinding
import com.example.potify.entities.Artist
import java.util.Locale

class ArtistAdapter(private val listener: OnFilteredListListener) :
    RecyclerView.Adapter<ArtistAdapter.ViewHolder>(), Filterable {

    var dataList: List<Artist> = emptyList()
    var filteredList = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemArtistSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemArtistSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            Glide.with(binding.root).load(artist.imageSrc).into(binding.artistImage)
            binding.artistName.text = artist.name
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
                val filteredData: List<Artist> = if (query.isEmpty()) {
                    emptyList()
                } else {
                    dataList.filter {
                        it.name.lowercase(Locale.getDefault()).contains(query)
                    }
                }
                val results = FilterResults()
                results.values = filteredData
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Artist>
                notifyDataSetChanged()

                listener.onFilteredList(filteredList)
            }
        }
    }

    interface OnFilteredListListener {
        fun onFilteredList(filteredData: List<Artist>)
    }
}
