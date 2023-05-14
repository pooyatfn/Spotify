package com.example.potify

data class GoodAfternoonItem(val imageSrc:String, val title:String)

class FakeGoodAfternoonData {

    companion object {
        fun getFakeData(): List<GoodAfternoonItem> {
            return listOf(
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\dance.png", "Dance & EDM"),
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\country", "Country Rocks"),
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\indie", "Indie"),
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\chilled", "Chilled Hits"),
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\electronic", "Electronic"),
                GoodAfternoonItem("C:\\Users\\pooya\\Desktop\\Potify\\are", "Are & Be"),
            )
        }
    }
}