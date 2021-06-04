package com.dicoding.picodiploma.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GamesEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "gameId")
    var gameId:String,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "released")
    var released:String,

    @ColumnInfo(name = "rating")
    var rating:String,

    @ColumnInfo(name = "image")
    var image:String,

    @ColumnInfo(name = "isfav")
    var isfav:Boolean = false
)