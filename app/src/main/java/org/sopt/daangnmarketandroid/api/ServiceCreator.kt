package org.sopt.daangnmarketandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {
    private const val BASE_URL =
        "https://asia-northeast3-daangnmarket-wesopt.cloudfunctions.net/api"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}