package com.example.potify.entities

data class Artist(val id: Int, val name: String, val imageSrc: String) {

    companion object {
        fun getFakeData(): List<Artist> {
            return listOf(
                Artist(1, "Whitesand", "https://s29.picofile.com/file/8463527050/Whitesand.png"),
                Artist(
                    2, "E-Soundtrax", "https://s29.picofile.com/file/8463527068/E_Soundtrax.png"
                ),
                Artist(
                    3,
                    "Peaceful Piano Vol 14",
                    "https://s29.picofile.com/file/8463527076/Peaceful_Piano_Vol_14.png"
                ),
                Artist(
                    4, "Luke Gajdus", "https://s29.picofile.com/file/8463527084/Luke_Gajdus.png"
                ),
                Artist(
                    5, "Brad DeRoche", "https://s29.picofile.com/file/8463527092/Brad_DeRoche.png"
                ),
            )
        }
    }
}