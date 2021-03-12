package com.example.android.cinemaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.android.kotlinhw_1.FilmsListFragment
import com.example.android.kotlinhw_1.R
import com.example.android.kotlinhw_1.viewModel.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FilmsListFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }
}


//    val a = MyKotlinFile()
//
//    fun getFilmName(filmName: String, year: Int) =
//        a.getGreetingsUser(filmName, year)
//
//
//    var aa : Int = 0
//    fun foo () {
//        var list = listOf<Int>(1,2,3,4,5)
//
//        list.forEach {
//             aa += it
//        }
//    }
//
//    var array = intArrayOf(1, 2, 3)
//
//    var arr =
//        arrayOf(intArrayOf(2, 3, 4, 5), intArrayOf(2, 3, 4, 5))
//
//    var arr2 = arrayOf(
//        intArrayOf(2, 3, 4, 5),
//        intArrayOf(2, 3, 4, 5),
//        intArrayOf(2, 3),
//        intArrayOf(55, 33, 4, 5, 6, 7, 8, 9, 88)
//    )