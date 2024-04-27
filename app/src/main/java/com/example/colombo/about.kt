package com.example.colombo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val backButton: Button = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            // Navigate back to the menu activity
            val intent = Intent(this@about, menu::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity
        }
    }
}
