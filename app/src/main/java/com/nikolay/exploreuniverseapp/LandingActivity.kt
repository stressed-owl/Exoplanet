package com.nikolay.exploreuniverseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nikolay.exploreuniverseapp.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val landingTitleText = "Explore The Solar System."
        val spannableString = SpannableString(landingTitleText)
        val goldColor = ForegroundColorSpan(resources.getColor(R.color.gold))
        spannableString.setSpan(goldColor, 12, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.landingTitleTextView.text = spannableString

        binding.flyButton.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}