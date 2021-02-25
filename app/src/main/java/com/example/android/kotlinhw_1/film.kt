package com.example.android.kotlinhw_1

data class film(
    val name: String, val image: Int, val release: Int,
    val genre: String, val rating: Float, val starring: List<String>, val duration: Float
) {
}