package com.dicoding.picodiploma.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.dicoding.picodiploma.core.data.source.local.entity.GamesEntity::class], version = 1, exportSchema = false)
abstract class GamesDatabase:RoomDatabase() {
    abstract  fun gamesDao(): GamesDao
}