package com.dicoding.picodiploma.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Game(
    val gameId: String,
    val name: String,
    val released: String,
    val rating: String,
    val image: String,
    val isFavorite: Boolean
) : Parcelable