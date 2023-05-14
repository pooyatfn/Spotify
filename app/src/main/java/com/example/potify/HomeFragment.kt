package com.example.potify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.potify.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]


        val goodAfternoonAdapter = GoodAfternoonAdapter()
        goodAfternoonAdapter.goods = viewModel.goodAfternoon
        binding?.goodAfternoon?.adapter = goodAfternoonAdapter

        val recentlyPlayedAdapter = RecentlyPlayedAdapter()
        recentlyPlayedAdapter.recentlies = viewModel.recentlyPlayed
        binding?.recentlyPlayed?.adapter = recentlyPlayedAdapter

        val madeForYouAdapter = MadeForYouAdapter()
        madeForYouAdapter.mades = viewModel.madeForYou
        binding?.madeForYou?.adapter = madeForYouAdapter

        val currentDir = System.getProperty("user.dir")
        println(currentDir)

    }

}
