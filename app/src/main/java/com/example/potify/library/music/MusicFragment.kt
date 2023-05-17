package com.example.potify.library.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.potify.databinding.FragmentMusicBinding
import com.google.android.material.tabs.TabLayoutMediator

class MusicFragment : Fragment() {

    private var binding: FragmentMusicBinding? = null
    private lateinit var musicVPA: MusicViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(layoutInflater, container, false)

        musicVPA = MusicViewPagerAdapter(childFragmentManager, lifecycle)
        binding!!.pager.adapter = musicVPA

        val tabLayout = binding!!.tabLayout
        val tabTitles: List<String> = listOf(
            "Playlists",
            "Artists",
            "Albums"
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