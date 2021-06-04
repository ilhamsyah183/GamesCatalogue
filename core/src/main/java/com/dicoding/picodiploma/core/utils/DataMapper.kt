package com.dicoding.picodiploma.core.utils

import com.dicoding.picodiploma.core.data.source.remote.response.GameResponse
import com.dicoding.picodiploma.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity> {
        val tourismList = ArrayList<com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity>()
        input.map {
            val tourism = com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity(
                gameId = it.id,
                name = it.name,
                released = it.released,
                rating = it.rating,
                image = it.background_image,
                isfav = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity>): List<Game> =
        input.map {
            Game(
                gameId = it.gameId,
                name = it.name,
                released = it.released,
                rating = it.rating,
                image = it.image,
                isFavorite = it.isfav
            )
        }

    fun mapDomainToEntity(input: Game) =
        com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity(
            gameId = input.gameId,
            name = input.name,
            released = input.released,
            rating = input.rating,
            image = input.image,
            isfav = input.isFavorite
        )
}