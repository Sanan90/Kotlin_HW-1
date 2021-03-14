package com.example.android.kotlinhw_1.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android.kotlinhw_1.FilmsListFragment
import com.example.android.kotlinhw_1.R
import com.example.android.kotlinhw_1.view.FilmInfoFragment
import java.lang.IllegalStateException
import kotlin.reflect.KClass

fun KClass<*>.createFragment(bundle: Bundle) : Fragment =
    when(this) {
        FilmsListFragment::class -> FilmsListFragment.newInstance()
        FilmInfoFragment::class -> FilmInfoFragment.newInstance(bundle)
        else -> throw IllegalStateException("")
    }

fun FragmentManager.addToBackStack(kClass: KClass<*>, bundle: Bundle) =
    beginTransaction().add(R.id.container, kClass.createFragment(bundle))
        .addToBackStack("")
        .commit()

fun FragmentManager.addToBackStack(kClass: KClass<*>) {
    beginTransaction().add(R.id.container, kClass.createFragment())
        .addToBackStack("")
        .commit()
}

fun KClass<*>.createFragment() : Fragment =
    when(this) {
        FilmsListFragment::class -> FilmsListFragment.newInstance()
        else -> throw IllegalStateException("")
    }