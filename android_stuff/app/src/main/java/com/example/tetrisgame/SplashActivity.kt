package com.example.tetrisgame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        // Hide the action bar for full-screen splash
        supportActionBar?.hide()
        
        // Start animations
        startAnimations()
        
        // Delay for 3 seconds then navigate to main activity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close splash activity so user can't go back
        }, 3000) // 3 seconds delay
    }
    
    private fun startAnimations() {
        // Animate the main title
        val titleText = findViewById<TextView>(R.id.titleText)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        titleText.startAnimation(fadeInAnimation)
        
        // Animate the subtitle with delay
        val subtitleText = findViewById<TextView>(R.id.subtitleText)
        val slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        subtitleText.startAnimation(slideUpAnimation)
    }
} 