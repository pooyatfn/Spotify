package com.example.potify.library.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.FragmentArtistLibraryBinding
import com.example.potify.entities.Artist

class ArtistFragment : Fragment(), ArtistAdapter.OnFilteredListListener {

    private var binding: FragmentArtistLibraryBinding? = null
    private val viewModel by viewModels<ArtistViewModel>()
    private lateinit var emptyView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistLibraryBinding.inflate(inflater, container, false)

        showEmptyState()

        emptyView = binding!!.emptyView
        recyclerView = binding!!.recentSearches

        val artistAdapter = ArtistAdapter(this)
        binding?.recentSearches?.adapter = artistAdapter
        viewModel.artistLiveData.observe(viewLifecycleOwner) { dataList ->
            artistAdapter.dataList = dataList
        }

        val searchView: androidx.appcompat.widget.SearchView = binding!!.searchBar
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Not used in this example
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                artistAdapter.filter.filter(newText)
                return true
            }
        })

        return binding!!.root
    }

    private fun showEmptyState() {
        binding!!.emptyView.visibility = View.VISIBLE
        binding!!.recentSearches.visibility = View.GONE
    }

    override fun onFilteredList(filteredData: List<Artist>) {
        if (filteredData.isEmpty()) {
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}