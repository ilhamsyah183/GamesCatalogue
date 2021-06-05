package com.dicoding.picodiploma.gamescatalogue.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.gamescatalogue.R
import com.dicoding.picodiploma.core.domain.model.Game
import com.dicoding.picodiploma.gamescatalogue.databinding.ActivityDetailGameBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailGameActivity : AppCompatActivity() {



    private val detailGameViewModel: DetailGameViewModel by viewModel()
    private lateinit var binding: ActivityDetailGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailGame = intent.getParcelableExtra<Game>(EXTRA_DATA)
        showDetailTourism(detailGame)
    }

    private fun showDetailTourism(detailGame: Game?) {
        detailGame?.let {
            supportActionBar?.title = detailGame.name
            binding.content.tvRating.text = detailGame.rating
            binding.content.tvReleased.text = detailGame.released
            Glide.with(this@DetailGameActivity)
                .load(detailGame.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGame.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailGameViewModel.setFavoriteGame(detailGame, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
