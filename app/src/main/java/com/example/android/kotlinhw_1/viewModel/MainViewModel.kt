package com.example.android.kotlinhw_1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.kotlinhw_1.model.Repository
import com.example.android.kotlinhw_1.model.RepositoryImpl

class MainViewModel (
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl : Repository = RepositoryImpl()) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getFilmsList() = getFilmsList2()

    private fun getFilmsList2() {
        liveDataToObserve.value = AppState.Success(repositoryImpl.getFilmsFromLocal())
    }
}