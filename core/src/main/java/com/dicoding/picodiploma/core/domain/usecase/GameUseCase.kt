package com.dicoding.picodiploma.core.domain.usecase

import com.dicoding.picodiploma.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGames():Flow<com.dicoding.picodiploma.core.data.Resource<List<Game>>>
    fun getFavoriteGames(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, state: Boolean)
}