package com.example.potify.library.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.potify.entities.Album

class AlbumViewModel : ViewModel() {

    val albumLiveData = MutableLiveData<List<Album>>()

    init {
        albumLiveData.value = Album.getFakeData()
    }
}