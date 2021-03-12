package com.example.android.kotlinhw_1.model

class RepositoryImpl : Repository {
    override fun getFilmsFromLocal(): List<Film> = getFilms()
}