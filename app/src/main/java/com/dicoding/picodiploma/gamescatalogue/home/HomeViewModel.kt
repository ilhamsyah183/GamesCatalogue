package com.dicoding.picodiploma.gamescatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.core.domain.usecase.GameUseCase

class HomeViewModel(gameUseCase: GameUseCase) : ViewModel() {
    val games = gameUseCase.getAllGames().asLiveData()
}
