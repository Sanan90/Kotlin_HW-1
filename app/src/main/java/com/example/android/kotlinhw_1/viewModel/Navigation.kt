package com.example.android.kotlinhw_1.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android.kotlinhw_1.R

class Navigation //  Врзвращаем navigation со своим фрагментМенеджером
    (private val fragmentManager: FragmentManager) {

    //  Принимает в качестве аргумента какой то фрагмент и информацию, нужно ли добавлять фрагмент в бекстек или нет.
    fun addFragment(
        fragment: Fragment?,
        useBackStack: Boolean
    ) {
        //  Открыть транзакцию
        val transaction =
            fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!)
        if (useBackStack) {
            transaction.addToBackStack(null)
        }
        //  ЗАкрыть транзакцию
        transaction.commit()
    }

    fun closeFragment() {
        fragmentManager.popBackStack()
    }

}