package com.example.colombo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.net.Uri
import android.widget.Button

class menu : AppCompatActivity() {
    private lateinit var videoView2: VideoView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        videoView2 = findViewById(R.id.videoView2)

        // Set video file path or URL
        val videoPath = "android.resource://" + packageName + "/" + R.raw.loop

        // Set video Uri
        videoView2.setVideoURI(Uri.parse(videoPath))

        // Start playing the video
        videoView2.start()

        // Loop the video
        videoView2.setOnCompletionListener { videoView2.start() }




        mediaPlayer = MediaPlayer.create(this, R.raw.wild)
        mediaPlayer.isLooping = true
        mediaPlayer.start()



        val startbtn: Button = findViewById(R.id.start)
        startbtn.setOnClickListener {
            val intent = Intent(this@menu, game::class.java)
            startActivity(intent)
            mediaPlayer.stop()

        }

        val exitButton: Button = findViewById(R.id.exit)
        exitButton.setOnClickListener {
            mediaPlayer.stop()
            finish() // This will close the current activity and exit the app
        }

        val aboutButton: Button = findViewById(R.id.about)
        aboutButton.setOnClickListener {
            val intent = Intent(this@menu, about::class.java)
            startActivity(intent)
            mediaPlayer.stop()

        }


    }



}
