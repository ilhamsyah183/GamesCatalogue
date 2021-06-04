package com.dicoding.picodiploma.gamescatalogue.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.core.domain.model.Game
import com.dicoding.picodiploma.core.domain.usecase.GameUseCase

class DetailGameViewModel(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteGame(game: Game, newStatus:Boolean) =
        gameUseCase.setFavoriteGame(game, newStatus)
}
