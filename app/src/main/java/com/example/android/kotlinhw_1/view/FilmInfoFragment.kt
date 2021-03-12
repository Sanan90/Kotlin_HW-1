package com.example.android.kotlinhw_1.view

import android.os.Bundle
import com.example.android.kotlinhw_1.databinding.FragmentFilmsListBinding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.kotlinhw_1.R
import com.example.android.kotlinhw_1.databinding.FragmentFilmInfoBinding
import com.example.android.kotlinhw_1.model.Film

class FilmInfoFragment : Fragment() {

    private var _binding : FragmentFilmInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmInfoBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let { film ->
            binding.filmInfoName.text = film.name
            binding.filmInfoRelease.text = film.release.toString()
            binding.filmInfoGenre.text = film.genre
            binding.filmInfoRaiting.text = film.rating.toString()
            binding.filmInfoDuration.text = film.duration.toString()
            binding.filmInfoStarring.text = film.starring.toString()
            binding.filmInfoAboutFilm.text = film.aboutFilm
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "film"

        fun newInstance(bundle: Bundle) : FilmInfoFragment {
            val fragment = FilmInfoFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}