package com.example.belajar_kotlin

import java.io.Serializable

data class Movie(
    val title: String,
    val imageResourceId: Int,
    val desc: Int,
    val rate: Double,
    val director:String,
    val genres: List<String>
): Serializable