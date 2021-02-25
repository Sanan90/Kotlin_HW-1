package com.example.android.cinemaapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.android.kotlinhw_1.MyKotlinFile
import com.example.android.kotlinhw_1.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews();
    }

    private fun initViews() {
        val film1 = findViewById<AppCompatImageView>(R.id.poster_1)
        val film2 = findViewById<AppCompatImageView>(R.id.poster_2)
        val film3 = findViewById<AppCompatImageView>(R.id.poster_3)
        val film4 = findViewById<AppCompatImageView>(R.id.poster_4)

        film1.setOnClickListener(this);
        film2.setOnClickListener(this);
        film3.setOnClickListener(this);
        film4.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.poster_1 -> {
                Toast.makeText(this, getFilmName("Начало", 2010), Toast.LENGTH_SHORT).show()
            }

            R.id.poster_2 -> {
                Toast.makeText(this, getFilmName("Господин никто", 2009), Toast.LENGTH_SHORT).show()
            }

            R.id.poster_3 -> {
                Toast.makeText(this, getFilmName("Крайний космос", 2018), Toast.LENGTH_SHORT).show()
            }

            R.id.poster_4 -> {
                Toast.makeText(this, getFilmName("Интерстеллар", 2014), Toast.LENGTH_SHORT).show()

            }
        }
    }

    val a = MyKotlinFile()

    fun getFilmName(filmName: String, year: Int) =
        a.getGreetingsUser(filmName, year)


    var aa : Int = 0
    fun foo () {
        var list = listOf<Int>(1,2,3,4,5)

        list.forEach {
             aa += it
        }
    }

    var array = intArrayOf(1, 2, 3)

    var arr =
        arrayOf(intArrayOf(2, 3, 4, 5), intArrayOf(2, 3, 4, 5))

    var arr2 = arrayOf(
        intArrayOf(2, 3, 4, 5),
        intArrayOf(2, 3, 4, 5),
        intArrayOf(2, 3),
        intArrayOf(55, 33, 4, 5, 6, 7, 8, 9, 88)
    )


}