package com.dicoding.picodiploma.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.core.ui.GamesAdapter
import com.dicoding.picodiploma.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.picodiploma.gamescatalogue.detail.DetailGameActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)
        supportActionBar?.title = "Favorite Page"
        getFavoriteData()
        unloadKoinModules(favoriteModule)
    }

    private fun getFavoriteData() {

        val gamesAdapter = GamesAdapter()
        gamesAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@FavoriteActivity, DetailGameActivity::class.java)
            intent.putExtra(DetailGameActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteGames.observe(this, { dataGame ->
            gamesAdapter.setData(dataGame)
            binding.viewEmpty.root.visibility = if (dataGame.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gamesAdapter
        }
    }
}