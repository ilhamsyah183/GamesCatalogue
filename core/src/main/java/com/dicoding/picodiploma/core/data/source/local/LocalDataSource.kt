package com.dicoding.picodiploma.core.data.source.local

import com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity
import com.dicoding.picodiploma.core.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gamesDao: GamesDao){


    fun getAllGames(): Flow<List<GamesEntity>> = gamesDao.getAllGames()
    fun getFavoriteGames(): Flow<List<GamesEntity>> = gamesDao.getFavoriteGames()
    suspend fun insertGame(gameList: List<GamesEntity>) = gamesDao.insertGame(gameList)
    fun setFavoriteGames(games: GamesEntity, newState: Boolean){
        games.isfav = newState
        gamesDao.updateFavoriteGames(games)
    }
}