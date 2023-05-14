package com.example.potify

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val goodAfternoon = FakeGoodAfternoonData.getFakeData()
    val recentlyPlayed = FakeRecentlyPlayedData.getFakeData()
    val madeForYou = FakeMadeForYouData.getFakeData()
}