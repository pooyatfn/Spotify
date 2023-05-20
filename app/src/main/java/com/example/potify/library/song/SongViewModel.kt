package com.example.potify.library.song

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.potify.entities.Music

class SongViewModel : ViewModel() {

    val songLiveData = MutableLiveData<List<Music>>()

    init {
        songLiveData.value = Music.getFakeData()
    }
}