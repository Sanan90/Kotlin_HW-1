package com.example.android.kotlinhw_1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.android.kotlinhw_1.Film
import com.example.android.kotlinhw_1.R
import com.example.android.kotlinhw_1.view.FilmListFragmentAdapter.MyViewHolder
import com.google.android.material.textview.MaterialTextView

class FilmListFragmentAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private var filmsData: MutableList<Film> = mutableListOf()
    private var fragment: Fragment? = null
    var myClickListener: MyClickListener? = null //  Создаем экземпляр нашего слушателя

    fun getMenuPosition(): Int {
        return menuPosition
    }

    private val menuPosition = 0

    fun FilmListFragmentAdapter(fragment: Fragment?) {
        this.fragment = fragment
    }

    fun MyItemClickListener(myClickListener: MyClickListener?) {
        this.myClickListener = myClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_for_film, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return filmsData.size
    }

    interface MyClickListener {
        fun onItemClick(view: View?, position: Int)
        fun onCheckClick(readCkeck: Boolean, position: Int)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var filmPosterImageView: AppCompatImageView? = null
        private var filmNameTextView: MaterialTextView? = null
        private var releaseTextView: MaterialTextView? = null
        private var genreTextView: MaterialTextView? = null
        private var raitingTextView: MaterialTextView? = null
        private var durationTextView: MaterialTextView? = null
        private var aboutFilmTextView: MaterialTextView? = null

        fun MyViewHolder(itemView: View) {
            super(itemView)
            filmPosterImageView = itemView.findViewById(R.id.filmPoster)
            filmNameTextView = itemView.findViewById(R.id.filmName)
            releaseTextView = itemView.findViewById(R.id.release)
            genreTextView = itemView.findViewById(R.id.genre)
            raitingTextView = itemView.findViewById(R.id.raiting)
            durationTextView = itemView.findViewById(R.id.duration)
            aboutFilmTextView = itemView.findViewById(R.id.aboutFilm)


            //  Вешаем слушатель на элементы списка
            itemView.setOnClickListener {
                val position: Int = this.getAdapterPosition()
                myClickListener.onItemClick(itemView, position)
            }
        }
    }
}