package com.hanseltritama.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanseltritama.rickandmortyapp.adapter.MyAdapter
import com.hanseltritama.rickandmortyapp.data.Result
import com.hanseltritama.rickandmortyapp.network.RetrofitInstance
import com.hanseltritama.rickandmortyapp.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter: MyAdapter

    private val myViewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupObserver()
        myViewModel.getCharacter()
    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycler_view.addItemDecoration(decoration)

        recyclerAdapter = MyAdapter(this)

        recycler_view.adapter = recyclerAdapter
    }

    private fun setupObserver() {
        myViewModel.characterLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                return@observe
            }
            recyclerAdapter.updateData(response as ArrayList<Result>)
        }
    }
}