package com.example.android.kotlinhw_1.model

import android.os.Parcelable
import com.example.android.kotlinhw_1.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val name: String = "Film name",
    val image: Int,
    val release: Int = 2021,
    val genre: String = "Genre",
    val rating: Float = 8.0F,
    val starring: List<String>,
    val duration: Float = 1.50F,
    val aboutFilm: String = "About film"
) : Parcelable

fun getFilms() = listOf(
    lambda(
        "Начало", R.drawable.nachalo, 2010, "Фантастика", 9F,
        listOf("Леонардо Ди Каприо", "Том Харди"), 2.5F
    ),
    lambda(
        "Господин никто", R.drawable.ms_nobody, 2009, "Фантастика", 9.6F,
        listOf("Джаред Лето", "Диана Крюгер"), 2.22F
    ),
    lambda(
        "Крайний космос", R.drawable.final_cosmos, 2018, "Фантастика", 8.8F,
        listOf("Герри Гудспид", "Пряник"), 0.20F
    ),
    lambda(
        "Интерстеллар", R.drawable.interstellar, 2014, "Фантастика", 9.3F,
        listOf("Меттью Макконехи", "Энн Хетеуэй"), 2.32F
    )
)

var lambda : (String, Int, Int, String, Float, List<String>, Float) -> Film = {
    name, image, release, genre, raiting, starring, duration ->
    val aboutFilm : String = "Название фильма $name. $name снят в $release году. " +
            "Жанр фильма $genre. Рейтинг фильма $raiting. " +
            "Фильм длится $duration \n В фильме снимались $starring"
    Film(name, image, release, genre, raiting, starring, duration, aboutFilm)
}

class FilmInfoBuild (private val filmInfo : (String, Int, Int, String, Float, List<String>, Float) -> Film ) {

    fun aboutFilm() {
        val film2 : Film = filmInfo("Господин никто", R.drawable.ms_nobody, 2009, "Фантастика", 9.6F,
            listOf("Джаред Лето", "Диана Крюгер"), 2.22F)
    }

}



