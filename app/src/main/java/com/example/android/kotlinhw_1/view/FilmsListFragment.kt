package com.example.android.kotlinhw_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.kotlinhw_1.databinding.FragmentFilmsListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.kotlinhw_1.view.FilmInfoFragment
import com.example.android.kotlinhw_1.view.FilmListFragmentAdapter
import com.example.android.kotlinhw_1.model.Film
import com.example.android.kotlinhw_1.viewModel.AppState
import com.example.android.kotlinhw_1.viewModel.MainViewModel

class FilmsListFragment : Fragment() {

    private var _binding: FragmentFilmsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    private val filmListFragmentAdapter = FilmListFragmentAdapter(object : OnItemViewClickListener {
        override fun onItemViewClick(film: Film) {
            Toast.makeText(context, film.name, Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager?.apply {
                beginTransaction().add(R.id.container, FilmInfoFragment.newInstance(Bundle().apply {
                    putParcelable(FilmInfoFragment.BUNDLE_EXTRA, film)
                }))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFilmsListBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView();
    }

    override fun onDestroy() {
        filmListFragmentAdapter.removeListener()
        super.onDestroy()
    }

    private fun initView() {
        binding.recycleForFilmsList.adapter = filmListFragmentAdapter
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmsList()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                filmListFragmentAdapter.setFilm(appState.filmsData)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(film: Film)
    }

    companion object {
        fun newInstance() = FilmsListFragment()
    }
}


//    private var recyclerView: RecyclerView? = null
//    private var moveToFirstPosition = false
//    var myClickListener: FilmListFragmentAdapter.MyClickListener? = null


//    private fun initRecyclerView() {
//        //  Эта установка служит для увеличения производительности системы
//        recyclerView!!.setHasFixedSize(true)
//
//        // Будем работать со встроченным менеджером
//        val layoutManager = LinearLayoutManager(context)
//        recyclerView?.layoutManager = layoutManager
//
//        //  Установим адаптер
//        filmListFragmentAdapter = FilmListFragmentAdapter()
//        recyclerView?.adapter = filmListFragmentAdapter
//
//        recyclerView?.scrollToPosition(0)


//        // Добавим разделитель карточек
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
//        itemDecoration.setDrawable(getResources().getDrawable(R.drawable., null));
//        recyclerView.addItemDecoration(itemDecoration);
//
//    }
