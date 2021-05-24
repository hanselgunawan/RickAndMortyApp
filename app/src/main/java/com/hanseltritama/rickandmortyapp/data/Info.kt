package com.hanseltritama.rickandmortyapp.data


import com.google.gson.annotations.SerializedName

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: Any
)