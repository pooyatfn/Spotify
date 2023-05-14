package com.example.potify

data class RecentlyPlayedItem(val imageSrc:String, val title:String)

class FakeRecentlyPlayedData {

    companion object {
        fun getFakeData(): List<RecentlyPlayedItem> {
            return listOf(
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\dance.png", "Dance & EDM"),
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\country", "Country Rocks"),
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\indie", "Indie"),
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\chilled", "Chilled Hits"),
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\electronic", "Electronic"),
                RecentlyPlayedItem("C:\\Users\\pooya\\Desktop\\Potify\\are", "Are & Be"),
            )
        }
    }
}