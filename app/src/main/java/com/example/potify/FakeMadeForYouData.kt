package com.example.potify

data class MadeForYouItem(val imageSrc:String, val title:String)

class FakeMadeForYouData {

    companion object {
        fun getFakeData(): List<MadeForYouItem> {
            return listOf(
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\dance.png", "Dance & EDM"),
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\country", "Country Rocks"),
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\indie", "Indie"),
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\chilled", "Chilled Hits"),
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\electronic", "Electronic"),
                MadeForYouItem("C:\\Users\\pooya\\Desktop\\Potify\\are", "Are & Be"),
            )
        }
    }
}