package com.hanseltritama.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hanseltritama.rickandmortyapp.network.RetrofitInstance
import com.hanseltritama.rickandmortyapp.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myViewModel: SharedViewModel by lazy {
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObserver()
        myViewModel.getCharacter()
    }

    private fun setupObserver() {
        myViewModel.characterLiveData.observe(this) { response ->
            if (response == null) {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                return@observe
            }

            userName = response.name

            setupUI()
        }
    }

    private fun setupUI() {
        name_text.text = userName
    }
}