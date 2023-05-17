package com.example.potify.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.potify.databinding.FragmentLibraryBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class LibraryFragment : Fragment() {

    private var binding: FragmentLibraryBinding? = null
    private lateinit var libraryViewPagerAdapter: LibraryViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(layoutInflater, container, false)

        libraryViewPagerAdapter = LibraryViewPagerAdapter(parentFragmentManager, lifecycle)
        binding!!.pager.adapter = libraryViewPagerAdapter

        val tabLayout = binding!!.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Music"))
        tabLayout.addTab(tabLayout.newTab().setText("Podcasts"))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding!!.pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        binding!!.pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TabLayoutMediator()
    }

}