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
        goodAfternoonAdapter.musics = viewModel.goodAfternoon
        binding?.goodAfternoon?.adapter = goodAfternoonAdapter

        val recentlyPlayedAdapter = RecentlyPlayedAdapter()
        recentlyPlayedAdapter.musics = viewModel.recentlyPlayed
        binding?.recentlyPlayed?.adapter = recentlyPlayedAdapter

        val madeForYouAdapter = MadeForYouAdapter()
        madeForYouAdapter.albums = viewModel.madeForYou
        binding?.madeForYou?.adapter = madeForYouAdapter

        val currentDir = System.getProperty("user.dir")
        println(currentDir)

    }

}
