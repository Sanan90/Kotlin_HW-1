package com.example.android.kotlinhw_1.viewModel

import com.example.android.kotlinhw_1.model.Film

sealed class AppState {
    data class Success(val filmsData : List<Film>) : AppState()
}