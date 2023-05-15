package com.example.potify.home.recentlyPlayed

import com.example.potify.entities.Music

class FakeRecentlyPlayedData {

    companion object {
        fun getFakeData(): List<Music> {
            return listOf(
                Music(114655, "Worth Fighting For", "https://vmusic.ir/wp-content/uploads/2022/02/Whitesand-Destiny-2022-225x225.jpg"),
                Music(114302, "Pavana", "https://vmusic.ir/wp-content/uploads/2022/02/Brad-DeRoche-Serenata-espanola-2022-225x225.jpg"),
                Music(114530, "Life (Piano Version)", "https://vmusic.ir/wp-content/uploads/2022/02/e-soundtrax-Lost-Piano-2022-225x225.jpg"),
                Music(114655, "Kardelen", "https://vmusic.ir/wp-content/uploads/2022/02/Peaceful-Piano-Vol-14-225x225.jpg"),
            )
        }
    }
}