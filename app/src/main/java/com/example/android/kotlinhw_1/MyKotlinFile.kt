package com.example.android.kotlinhw_1

class MyKotlinFile {

    public fun getGreetingsUser(filmName: String, year: Int): String {
        return "${getFullname(filmName, year)}"
    }
}

fun getFullname(filmName: String, year: Int) =
    "Фильм называется $filmName. Снят в ${year.toString()} году"
