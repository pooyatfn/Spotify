package com.example.potify.home.madeForYou

import com.example.potify.entities.Album

class FakeMadeForYouData {

    companion object {
        fun getFakeData(): List<Album> {
            return listOf(
                Album(114503, "Destiny","Whitesand","https://vmusic.ir/wp-content/uploads/2022/02/Whitesand-Destiny-2022-225x225.jpg"),
                Album(114482, "Lost Piano ", "E-Soundtrax", "https://vmusic.ir/wp-content/uploads/2022/02/e-soundtrax-Lost-Piano-2022-225x225.jpg"),
                Album(114242, "Serenata española","Brad DeRoche","https://vmusic.ir/wp-content/uploads/2022/02/Brad-DeRoche-Serenata-espanola-2022-225x225.jpg"),
                Album(114074, "Peaceful Piano Vol 14","Vmusic PlayList", "https://vmusic.ir/wp-content/uploads/2022/02/Peaceful-Piano-Vol-14-225x225.jpg"),
            )
        }
    }
}