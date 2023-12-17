package com.example.androidexpert.ui.detail

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.androidexpert.R
import com.example.androidexpert.core.domain.model.MovieItem
import com.example.androidexpert.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTourismViewModel: DetailActivityViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovie = intent.getParcelableExtra<MovieItem>(EXTRA_DATA)
        showDetailTourism(detailMovie)




        detailTourismViewModel.getFavByMovie().observe(this){
            if (detailMovie != null) {
                setStatusFavorite(false, detailMovie)
            }
            it.forEach {
                if(it.movieId == detailMovie?.movieId){
                    setStatusFavorite(true, detailMovie)
                }
            }
        }

    }

    private fun showDetailTourism(detailMovie: MovieItem?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            binding.content.tvDetailDescription.text = detailMovie.overview
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500"+detailMovie.posterPath)
                .into(binding.ivDetailImage)

            binding.content.tvDetailLanguage.text = "Language: ${detailMovie.language}"
            binding.content.tvDetailReleaseDate .text = detailMovie.releaseDate

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean, movieItem: MovieItem) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
            binding.fab.setOnClickListener {
                detailTourismViewModel.deleteFavMovie(movieItem)
            }
            detailTourismViewModel.getFavByMovie()
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24))
            binding.fab.setOnClickListener {
                detailTourismViewModel.addFavMovie(movieItem)
            }
            detailTourismViewModel.getFavByMovie()
        }
    }
}