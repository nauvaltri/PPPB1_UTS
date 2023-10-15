package com.example.belajar_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajar_kotlin.databinding.ActivityHomePageBinding

class  HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("usn")


        val movieList = mutableListOf(
            Movie("Bytnmeh",R.drawable.poster1, R.string.desc, 4.8,"Andrew Stanton",listOf("adults", "Live-Action")),
            Movie("Terrifier",R.drawable.poster2,R.string.desc, 4.8,"Starbrust",listOf("adults", "Live-Action")),
            Movie("The Strangers",R.drawable.poster3,R.string.desc, 4.7,"Leward",listOf("adult", "Live-Action")),
            Movie("Out Of The Dark",R.drawable.poster4,R.string.desc, 4.0,"Lluís Quílez ",listOf("adult", "Live-Action")),
            Movie("The 5th Wave",R.drawable.poster5,R.string.desc, 4.6,"Lee Strokter",listOf("adult", "Live-Action")),
            Movie("Tsunami",R.drawable.poster6,R.string.desc, 4.5,"Enrico Casarosa",listOf("adult", "Live-Action")),
        )



        val adapter = MovieAdapter(movieList) { clickedMovie ->
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("movieData", clickedMovie)
            startActivity(intent)
        }

        with(binding){
            tvUsername.text = username
            rvMovies.adapter = adapter
        }
    }
}