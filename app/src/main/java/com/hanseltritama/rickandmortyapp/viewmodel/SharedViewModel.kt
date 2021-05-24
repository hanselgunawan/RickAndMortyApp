package com.hanseltritama.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanseltritama.rickandmortyapp.data.CharacterResult
import com.hanseltritama.rickandmortyapp.network.RetrofitInstance
import com.hanseltritama.rickandmortyapp.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    private val retrofitInstance =
            RetrofitInstance.getInstance().create(RetrofitService::class.java)

    val characterLiveData: MutableLiveData<CharacterResult> = MutableLiveData()

    fun getCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = retrofitInstance.getAllCharacters()
            characterLiveData.postValue(response)
        }
    }
}