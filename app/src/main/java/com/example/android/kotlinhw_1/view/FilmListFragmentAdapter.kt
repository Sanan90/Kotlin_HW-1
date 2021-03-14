package com.example.android.kotlinhw_1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.android.kotlinhw_1.model.Film
import com.example.android.kotlinhw_1.FilmsListFragment
import com.example.android.kotlinhw_1.R
import com.example.android.kotlinhw_1.FilmsListFragment.OnItemViewClickListener
import com.example.android.kotlinhw_1.view.FilmListFragmentAdapter.MyViewHolder
import com.google.android.material.textview.MaterialTextView

class FilmListFragmentAdapter (private var onItemViewClickListener: OnItemViewClickListener?) :
    RecyclerView.Adapter<FilmListFragmentAdapter.MyViewHolder>() {

    private var filmsData: List<Film> = listOf()

    fun setFilm(data: List<Film>) {
        filmsData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_for_film, parent, false) as View
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(filmsData[position])
    }


    override fun getItemCount(): Int {
        return filmsData.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(film: Film) {
            itemView.apply {
                findViewById<MaterialTextView>(R.id.filmName).text =
                    film.name
                findViewById<MaterialTextView>(R.id.release).text =
                    film.release.toString()
                findViewById<MaterialTextView>(R.id.genre).text =
                    film.genre
                findViewById<MaterialTextView>(R.id.duration).text =
                    film.duration.toString()
                findViewById<MaterialTextView>(R.id.raiting).text =
                    film.rating.toString()
                findViewById<MaterialTextView>(R.id.starring).text =
                    film.starring.toString()
                findViewById<MaterialTextView>(R.id.aboutFilm).text =
                    film.aboutFilm
//                findViewById<AppCompatImageView>(R.id.filmPoster).background =
//                    film.image
            }
        }
    }

//            //  Вешаем слушатель на элементы списка
//            itemView.setOnClickListener {
//                val position: Int = this.getAdapterPosition()
//                myClickListener.onItemClick(itemView, position)
//            }
//        }
//    }
//
//
//    private var fragment: Fragment? = null
//    var myClickListener: MyClickListener? = null //  Создаем экземпляр нашего слушателя
//
//    fun getMenuPosition(): Int {
//        return menuPosition
//    }
//
//    private val menuPosition = 0
//
//    fun FilmListFragmentAdapter(fragment: Fragment?) {
//        this.fragment = fragment
//    }
//
//    fun MyItemClickListener(myClickListener: MyClickListener?) {
//        this.myClickListener = myClickListener
//    }
//
//
//    interface MyClickListener {
//        fun onItemClick(view: View?, position: Int)
//        fun onCheckClick(readCkeck: Boolean, position: Int)
//    }



}