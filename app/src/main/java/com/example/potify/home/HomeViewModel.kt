package com.example.potify.home

import androidx.lifecycle.ViewModel
import com.example.potify.home.goodAfternoon.FakeGoodAfternoonData
import com.example.potify.home.madeForYou.FakeMadeForYouData
import com.example.potify.home.recentlyPlayed.FakeRecentlyPlayedData

class HomeViewModel : ViewModel() {

    val goodAfternoon = FakeGoodAfternoonData.getFakeData()
    val recentlyPlayed = FakeRecentlyPlayedData.getFakeData()
    val madeForYou = FakeMadeForYouData.getFakeData()
}