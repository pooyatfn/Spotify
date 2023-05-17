package com.example.potify.library

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.potify.library.music.MusicFragment
import com.example.potify.library.podcast.PodcastFragment

class LibraryViewPagerAdapter(fm: FragmentManager, lf: Lifecycle) : FragmentStateAdapter(fm, lf) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) MusicFragment() else PodcastFragment()
    }

}