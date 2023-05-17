package com.example.potify.library.music

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.potify.library.music.album.AlbumFragment
import com.example.potify.library.music.artist.ArtistFragment
import com.example.potify.library.music.playlist.PlaylistFragment

class MusicViewPagerAdapter(fm: FragmentManager, lf: Lifecycle) : FragmentStateAdapter(fm, lf) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) PlaylistFragment() else if (position == 1) ArtistFragment() else AlbumFragment()
    }
}