package com.hanseltritama.rickandmortyapp.data


import com.google.gson.annotations.SerializedName

data class CharacterResult(
    val info: Info,
    val results: List<Result>
)