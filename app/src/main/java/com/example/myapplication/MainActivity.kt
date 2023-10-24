package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.getPhotoButton)
        button1.setOnClickListener {
            // This will allow a call to network call to NASA API when button1 is clicked
            getAstronomyPhoto()
                // This will be in charge of getting API calls

        }
    }
    private fun getAstronomyPhoto() {
        val client = AsyncHttpClient()

        client["https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY", object:
            JsonHttpResponseHandler() {

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                // Access a JSON array response with `json.jsonArray`
//                Log.d("DEBUG ARRAY", json.jsonArray.toString())


                // Access a JSON object response with `json.jsonObject`
                Log.d("DEBUG OBJECT", json.jsonObject.toString())
                val astronomyPhotoURL = json.jsonObject.getString("url")
                // use image lading library
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("ASTRONOMY Photo FAIL", response)
            }
        }]
    }
}