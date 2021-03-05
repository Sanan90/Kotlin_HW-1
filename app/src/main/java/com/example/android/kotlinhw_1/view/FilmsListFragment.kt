package com.example.android.kotlinhw_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.kotlinhw_1.view.FilmListFragmentAdapter

class FilmsListFragment : Fragment() {

    private var filmListFragmentAdapter: FilmListFragmentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var moveToFirstPosition = false
    var myClickListener: FilmListFragmentAdapter.MyClickListener? = null


    fun newInstance(): FilmsListFragment? {
        val fragment = FilmsListFragment()
        val args = Bundle()
        fragment.setArguments(args)
        return fragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view);
    }


    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recycl_for_films_list)
        initRecyclerView()
    }


    private fun initRecyclerView() {
        //  Эта установка служит для увеличения производительности системы
        recyclerView!!.setHasFixedSize(true)

        // Будем работать со встроченным менеджером
        val layoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager

        //  Установим адаптер
        filmListFragmentAdapter = FilmListFragmentAdapter()
        recyclerView?.adapter = filmListFragmentAdapter

//        recyclerView?.scrollToPosition(0)


//        // Добавим разделитель карточек
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
//        itemDecoration.setDrawable(getResources().getDrawable(R.drawable., null));
//        recyclerView.addItemDecoration(itemDecoration);

    }




}