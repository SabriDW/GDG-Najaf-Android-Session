package com.sabriapps.myapplication.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeInterface {

    @GET("search/anime")
    fun searchForAnime(@Query("q") name: String): Call<AnimeSearchResponse>

}
