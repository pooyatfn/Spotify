package com.example.potify.home.recentlyPlayed

import com.example.potify.entities.Music

class FakeRecentlyPlayedData {

    companion object {
        fun getFakeData(): List<Music> {
            return listOf(
                Music(
                    114655,
                    "Worth Fighting For",
                    "Whitesand",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Whitesand-Destiny-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Whitesand - Destiny (2022)/128k/01) Whitesand - Worth Fighting For.mp3"
                ),
                Music(
                    114302,
                    "Pavana",
                    "Brad DeRoche",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Brad-DeRoche-Serenata-espanola-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Brad DeRoche - Serenata española (2022)/128k/02) Brad DeRoche - Pavana.mp3"
                ),
                Music(
                    114530,
                    "Life (Piano Version)",
                    "E-Soundtrax",
                    "https://vmusic.ir/wp-content/uploads/2022/02/e-soundtrax-Lost-Piano-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/e soundtrax - Lost Piano (2022)/128k/01) e-soundtrax - Life (Piano Version).mp3"
                ),
                Music(
                    114655,
                    "Kardelen",
                    "Whitesand",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Peaceful-Piano-Vol-14-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Whitesand - Destiny (2022)/128k/01) Whitesand - Worth Fighting For.mp3"
                ),
            )
        }
    }
}