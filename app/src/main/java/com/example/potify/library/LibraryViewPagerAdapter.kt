package com.example.potify.library

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class LibraryViewPagerAdapter(fm: FragmentManager, lf: Lifecycle) : FragmentStateAdapter(fm, lf) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) SongFragment() else if (position == 1) ArtistFragment() else AlbumFragment()
    }

}