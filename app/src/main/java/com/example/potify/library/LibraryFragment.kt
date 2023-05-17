package com.example.potify.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.potify.databinding.FragmentLibraryBinding
import com.google.android.material.tabs.TabLayoutMediator

class LibraryFragment : Fragment() {

    private var binding: FragmentLibraryBinding? = null
    private lateinit var libraryVPA: LibraryViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)

        libraryVPA = LibraryViewPagerAdapter(childFragmentManager, lifecycle)
        binding!!.pager.adapter = libraryVPA

        val tabLayout = binding!!.tabLayout
        val tabTitles: List<String> = listOf(
            "Music",
            "Podcasts",
        )
        TabLayoutMediator(tabLayout, binding!!.pager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TabLayoutMediator()
    }

}