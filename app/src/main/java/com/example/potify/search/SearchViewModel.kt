package com.example.potify.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.potify.entities.Album
import com.example.potify.entities.Artist
import com.example.potify.entities.Music

class SearchViewModel : ViewModel() {

    val searchLiveData = MutableLiveData<List<Any>>()

    init {
        val dataList = mutableListOf<Any>()
        dataList.addAll(Music.getFakeData())
        dataList.addAll(Album.getFakeData())
        dataList.addAll(Artist.getFakeData())
        searchLiveData.value = dataList
    }
}