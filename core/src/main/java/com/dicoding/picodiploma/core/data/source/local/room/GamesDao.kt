package com.dicoding.picodiploma.core.data.source.local.room

import androidx.room.*
import com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface GamesDao {
    @Query("SELECT * FROM games")
    fun getAllGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games where isfav = 1")
    fun getFavoriteGames():Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game:List<GamesEntity>)

    @Update
    fun updateFavoriteGames(game: GamesEntity)

}