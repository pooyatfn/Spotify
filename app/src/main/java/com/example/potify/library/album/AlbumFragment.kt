package com.example.potify.library.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.FragmentAlbumLibraryBinding
import com.example.potify.entities.Album

class AlbumFragment : Fragment(), AlbumAdapter.OnFilteredListListener {

    private var binding: FragmentAlbumLibraryBinding? = null
    private val viewModel by viewModels<AlbumViewModel>()
    private lateinit var emptyView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumLibraryBinding.inflate(inflater, container, false)

        showEmptyState()

        emptyView = binding!!.emptyView
        recyclerView = binding!!.recentSearches

        val albumAdapter = AlbumAdapter(this)
        binding?.recentSearches?.adapter = albumAdapter
        viewModel.albumLiveData.observe(viewLifecycleOwner) { dataList ->
            albumAdapter.dataList = dataList
        }

        val searchView: androidx.appcompat.widget.SearchView = binding!!.searchBar
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Not used in this example
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                albumAdapter.filter.filter(newText)
                return true
            }
        })

        return binding!!.root
    }

    private fun showEmptyState() {
        binding!!.emptyView.visibility = View.VISIBLE
        binding!!.recentSearches.visibility = View.GONE
    }

    override fun onFilteredList(filteredData: List<Album>) {
        if (filteredData.isEmpty()) {
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}