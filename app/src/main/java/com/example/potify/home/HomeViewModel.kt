package com.example.potify.home

import androidx.lifecycle.ViewModel
import com.example.potify.entities.Album
import com.example.potify.entities.Music

class HomeViewModel : ViewModel() {

    val goodAfternoon = Music.getFakeData().shuffled().take(6)
    val recentlyPlayed = Music.getFakeData().shuffled()
    val madeForYou = Album.getFakeData().shuffled()
}