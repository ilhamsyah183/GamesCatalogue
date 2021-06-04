package com.dicoding.picodiploma.core.domain.usecase

import com.dicoding.picodiploma.core.domain.model.Game
import com.dicoding.picodiploma.core.domain.repository.IGameRepository

class GamesInteractor(private val gameRepository: IGameRepository): GameUseCase {

    override fun getAllGames() = gameRepository.getAllGames()

    override fun getFavoriteGames() = gameRepository.getFavoriteGames()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGames(game, state)
}