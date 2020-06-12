package com.sabriapps.myapplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sabriapps.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var x = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberOfTaps.setText(x.toString())

        tapHereButton.setOnClickListener {
            x++
            numberOfTaps.setText(x.toString())
        }


        openInternetActivityButton.setOnClickListener {
            val intent = Intent(this, InternetActivity::class.java)
            startActivity(intent)
        }


    }


}