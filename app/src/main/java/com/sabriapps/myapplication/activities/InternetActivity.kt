package com.sabriapps.myapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sabriapps.myapplication.R
import com.sabriapps.myapplication.network.AnimeInterface
import com.sabriapps.myapplication.network.AnimeSearchResponse
import kotlinx.android.synthetic.main.activity_internet.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class InternetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animeService = retrofit.create(AnimeInterface::class.java)

        val call = animeService.searchForAnime("naruto")

        call.enqueue(object : Callback<AnimeSearchResponse> {

            override fun onFailure(call: Call<AnimeSearchResponse>, t: Throwable) {
                Toast.makeText(this@InternetActivity, "Loading failed", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<AnimeSearchResponse>,
                response: Response<AnimeSearchResponse>
            ) {

                val result1: AnimeSearchResponse.Result? = response.body()?.results?.get(0)

                result1?.let { result1 ->
                    animeTitleTextView.setText(result1.title)
                }


            }
        })
    }
}




