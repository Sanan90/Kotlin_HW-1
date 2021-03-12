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
    Film(
        "Начало", R.drawable.nachalo, 2010, "Фантастика", 9F,
        listOf("Леонардо Ди Каприо", "Том Харди"), 2.5F, "About nachalo"
    ),
    Film(
        "Господин никто", R.drawable.ms_nobody, 2009, "Фантастика", 9.6F,
        listOf("Джаред Лето", "Диана Крюгер"), 2.22F, "About ms nobody"
    ),
    Film(
        "Крайний космос", R.drawable.final_cosmos, 2018, "Фантастика", 8.8F,
        listOf("Герри Гудспид", "Пряник"), 0.20F, "About final cosmos"
    ),
    Film(
        "Интерстеллар", R.drawable.interstellar, 2014, "Фантастика", 9.3F,
        listOf("Меттью Макконехи", "Энн Хетеуэй"), 2.32F, "About interstellar"
    )
)

