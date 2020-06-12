package com.sabriapps.myapplication.network

import com.google.gson.annotations.SerializedName

data class AnimeSearchResponse(
    @SerializedName("request_hash")
    var requestHash: String = "",
    @SerializedName("request_cached")
    var requestCached: Boolean = false,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int = 0,
    @SerializedName("last_page")
    var lastPage: Int = 0,
    @SerializedName("results")
    var results: List<Result> = listOf()
) {

    data class Result(
        @SerializedName("mal_id")
        var malId: Int = 0,
        @SerializedName("url")
        var url: String = "",
        @SerializedName("image_url")
        var imageUrl: String = "",
        @SerializedName("title")
        var title: String = "",
        @SerializedName("type")
        var type: String = "",
        @SerializedName("episodes")
        var episodes: Any? = Any(),
        @SerializedName("airing")
        var airing: Boolean = false,
        @SerializedName("score")
        var score: Double = 0.0,
        @SerializedName("members")
        var members: Int = 0,
        @SerializedName("synopsis")
        var synopsis: String = "",
        @SerializedName("start_date")
        var startDate: String = "",
        @SerializedName("rated")
        var rated: String = "",
        @SerializedName("end_date")
        var endDate: String = ""
    )
}
