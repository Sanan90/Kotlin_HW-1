package com.example.android.kotlinhw_1.model

interface Repository {
    fun getFilmsFromLocal() : List<Film>
}