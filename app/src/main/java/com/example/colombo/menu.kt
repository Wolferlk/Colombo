package com.example.colombo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.net.Uri

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
    }
}
