package com.example.potify.library.artist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.potify.entities.Artist

class ArtistViewModel : ViewModel() {

    val artistLiveData = MutableLiveData<List<Artist>>()

    init {
        artistLiveData.value = Artist.getFakeData()
    }
}