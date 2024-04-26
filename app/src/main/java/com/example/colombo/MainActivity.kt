package com.example.colombo

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button
    private lateinit var mediaPlayer2: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        startButton = findViewById(R.id.startButton)


        // Simulate loading process
        simulateLoading()

        mediaPlayer2 = MediaPlayer.create(this, R.raw.wild)
        mediaPlayer2.isLooping = true
        mediaPlayer2.start()

        startButton.setOnClickListener {
            // Navigate to the Intro activity
            mediaPlayer2.stop()
            val intent = Intent(this@MainActivity, introduct::class.java)
            startActivity(intent)
            finish()




        }
    }

    private fun simulateLoading() {
        // Show progress bar
        progressBar.visibility = View.VISIBLE

        // Simulate loading for 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Hide progress bar
            progressBar.visibility = View.GONE
            // Show start button
            startButton.visibility = View.VISIBLE
        }, 5000)
    }


    override fun onDestroy() {
        super.onDestroy()
        // Release MediaPlayer resources

        mediaPlayer2.release()
    }
}
