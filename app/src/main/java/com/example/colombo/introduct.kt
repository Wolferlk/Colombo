package com.example.colombo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import android.net.Uri


class introduct : AppCompatActivity() {
    private lateinit var nextButton: Button
    private lateinit var videoView: VideoView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduct)




        videoView = findViewById(R.id.videoView)


        val videoPath = "android.resource://" + packageName + "/" + R.raw.intro


        videoView.setVideoURI(Uri.parse(videoPath))


        videoView.start()

        videoView.setOnClickListener {
            val intent = Intent(this@introduct, menu::class.java)
            startActivity(intent)
            finish()

        }


        videoView.setOnCompletionListener {
            val intent = Intent(this@introduct, menu::class.java)
            startActivity(intent)
            finish()
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        // Release VideoView resources when the activity is destroyed
        videoView.stopPlayback()
    }
}