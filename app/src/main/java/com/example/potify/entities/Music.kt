package com.example.potify.entities

data class Music(
    val id: Int, val title: String, val artist: String, val imageUrl: String, val trackUrl: String
) {
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
                    114593,
                    "Thaïs  Acte Deux Méditation religieuse",
                    "Various Artists",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Various-Artists-Romantic-Violin-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Various Artists - Romantic Violin (2022)/128k/01) Various Artists - Thaïs  Acte Deux Méditation religieuse.mp3"
                ),
                Music(
                    114009,
                    "Your Time Is Now",
                    "Christoffer Moe Ditlevsen",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Christoffer-Moe-Ditlevsen-Your-Time-Is-Now-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Christoffer Moe Ditlevsen - Your Time Is Now (2022)/128k/01) Christoffer Moe Ditlevsen - Your Time Is Now.mp3"
                ),
                Music(
                    113965,
                    "Flowing",
                    "Luke Gajdus",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Luke-Gajdus-In-Breath-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Luke Gajdus - In Breath (2022)/128k/01) Luke Gajdus - Flowing.mp3"
                ),
                Music(
                    114655,
                    "Kardelen",
                    "Whitesand",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Peaceful-Piano-Vol-14-225x225.jpg",
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
                    114760,
                    "By the Sea",
                    "Frozen Silence",
                    "https://vmusic.ir/wp-content/uploads/2022/02/Frozen-Silence-Emotion-2022-225x225.jpg",
                    "https://dl.vmusic.ir/2022/02/Frozen Silence - Emotion (2022)/128k/01) Frozen Silence - By the Sea.mp3"
                ),
            )
        }
    }
}