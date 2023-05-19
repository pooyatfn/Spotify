package com.example.potify.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.potify.databinding.FragmentHomeBinding
import com.example.potify.home.goodAfternoon.GoodAfternoonAdapter
import com.example.potify.home.madeForYou.MadeForYouAdapter
import com.example.potify.home.recentlyPlayed.RecentlyPlayedAdapter

class HomeFragment : Fragment() {

    private val viewModel by activityViewModels<HomeViewModel>()
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        val goodAfternoonAdapter = GoodAfternoonAdapter()
        binding?.goodAfternoon?.adapter = goodAfternoonAdapter
        viewModel.goodAfternoonLiveData.observe(viewLifecycleOwner) { musics ->
            goodAfternoonAdapter.musics = musics
        }

        val recentlyPlayedAdapter = RecentlyPlayedAdapter()
        binding?.recentlyPlayed?.adapter = recentlyPlayedAdapter
        viewModel.recentlyPlayedLiveData.observe(viewLifecycleOwner) { musics ->
            recentlyPlayedAdapter.musics = musics
        }

        val madeForYouAdapter = MadeForYouAdapter()
        binding?.madeForYou?.adapter = madeForYouAdapter
        viewModel.madeForYouLiveData.observe(viewLifecycleOwner) { albums ->
            madeForYouAdapter.albums = albums
        }
    }

}
