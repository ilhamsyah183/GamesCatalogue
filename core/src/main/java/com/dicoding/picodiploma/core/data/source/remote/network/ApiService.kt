package com.dicoding.picodiploma.core.data.source.remote.network

import com.dicoding.picodiploma.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET

interface ApiService {
    //limit:20000 Request a month for this key
    @GET("games?page=1&key=3be805f566b04b859a77b7ed9718ca18")
    suspend fun getList(): ListGameResponse
}