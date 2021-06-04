package com.dicoding.picodiploma.core.data

import com.dicoding.picodiploma.core.data.source.local.LocalDataSource
import com.dicoding.picodiploma.core.data.source.remote.RemoteDataSource
import com.dicoding.picodiploma.core.data.source.remote.network.ApiResponse
import com.dicoding.picodiploma.core.data.source.remote.response.GameResponse
import com.dicoding.picodiploma.core.domain.model.Game
import com.dicoding.picodiploma.core.domain.repository.IGameRepository
import com.dicoding.picodiploma.core.utils.AppExecutors
import com.dicoding.picodiploma.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository {


    override fun getAllGames(): Flow<Resource<List<Game>>> =
        object : com.dicoding.picodiploma.core.data.NetworkBoundResource<List<Game>, List<GameResponse>>(){
            override fun loadFromDB(): Flow<List<Game>> {
               return localDataSource.getAllGames().map { DataMapper.mapEntitiesToDomain(it) }
           }

            override fun shouldFetch(data: List<Game>?): Boolean =
               data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
               remoteDataSource.getAllGames()

            override suspend fun saveCallResult(data: List<GameResponse>) {
               val gameList = DataMapper.mapResponsesToEntities(data)
               localDataSource.insertGame(gameList)
           }
       }.asFlow()

    override fun getFavoriteGames(): Flow<List<Game>> {
           return localDataSource.getFavoriteGames().map { DataMapper.mapEntitiesToDomain(it) }
        }

    override fun setFavoriteGames(game: Game, state: Boolean) {
        val gamesEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGames(gamesEntity, state) }
    }

}