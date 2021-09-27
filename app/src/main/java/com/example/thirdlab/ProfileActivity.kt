package com.example.thirdlab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thirdlab.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileSettingsText.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        binding.profileAboutText.setOnClickListener {
            startActivity(
                AboutActivity.newInstance(this, "https://www.journaldev.com")
            )
        }

        binding.profileShareText.setOnClickListener {
            shareApp()
        }
    }

    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.shareDescription))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}