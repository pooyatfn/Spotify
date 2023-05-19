package com.example.potify.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.FragmentSearchBinding

class SearchFragment : Fragment(), SearchAdapter.OnFilteredListListener {

    private var binding: FragmentSearchBinding? = null
    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var emptyView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        showEmptyState()

        emptyView = binding!!.emptyView
        recyclerView = binding!!.recentSearches

        val searchAdapter = SearchAdapter(this)
        binding?.recentSearches?.adapter = searchAdapter
        viewModel.searchLiveData.observe(viewLifecycleOwner) { dataList ->
            searchAdapter.dataList = dataList
        }

        val searchView: androidx.appcompat.widget.SearchView = binding!!.searchBar
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Not used in this example
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchAdapter.filter.filter(newText)
                return true
            }
        })

        return binding!!.root
    }

    private fun showEmptyState() {
        binding!!.emptyView.visibility = View.VISIBLE
        binding!!.recentSearches.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onFilteredList(filteredData: List<Any>) {
        if (filteredData.isEmpty()) {
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}