package com.dicoding.picodiploma.core.domain.repository

import com.dicoding.picodiploma.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
        fun getAllGames(): Flow<com.dicoding.picodiploma.core.data.Resource<List<Game>>>

        fun getFavoriteGames(): Flow<List<Game>>

        fun setFavoriteGames(game: Game, state: Boolean)
}