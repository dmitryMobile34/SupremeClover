package com.miHoYo.GenshinImpa

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miHoYo.GenshinImpa.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        var gemsArray = listOf(R.drawable.gem1, R.drawable.gem2, R.drawable.gem3)

        binding.buttonHummer.setOnClickListener {
            binding.buttonHummerWrap.strokeColor = resources.getColor(R.color.primary_dark)

            if (null != binding.gemFirst.drawable) {
                if (null != binding.gemSecond.drawable) {
                    if (null != binding.gemThird.drawable) {
                        binding.gemFirst.setImageDrawable(null)
                        binding.gemSecond.setImageDrawable(null)
                        binding.gemThird.setImageDrawable(null)
                        binding.gemFirstWrap.strokeColor = resources.getColor(R.color.primary_dark)
                        binding.gemSecondWrap.strokeColor = resources.getColor(R.color.primary_dark)
                        binding.gemThirdWrap.strokeColor = resources.getColor(R.color.primary_dark)
                    } else {
                        binding.buttonHummerWrap.strokeColor = resources.getColor(R.color.purple_flash)
                        binding.gemFirstWrap.strokeColor = resources.getColor(R.color.red_flash)
                        binding.gemSecondWrap.strokeColor = resources.getColor(R.color.red_flash)
                        binding.gemThirdWrap.strokeColor = resources.getColor(R.color.red_flash)
                        binding.gemThird.setImageResource(gemsArray.random())
                        binding.textMainWindow.setText("Well, looks like u failed, Traveller. Something went wrong. I told you that no one passed through yet. ")
                    }
                } else {
                    binding.gemSecond.setImageResource(gemsArray.random())
                    binding.gemSecondWrap.strokeColor = resources.getColor(R.color.green_flash)
                    binding.textMainWindow.setText("Both are placed perfect. Smash it one more time. But use that hummer wisely. ")
                }
            } else {
                binding.gemFirst.setImageResource(gemsArray.random())
                binding.gemFirstWrap.strokeColor = resources.getColor(R.color.green_flash)
                binding.textMainWindow.setText("Wow, first one looks great. But what about another one? Trust me you are not the first who trying to enter that ruins.")
            }

        }

        binding.buttonSettings.setOnClickListener {
            Toast.makeText(this, "This feature is not yet implemented.", Toast.LENGTH_SHORT).show()
        }

        binding.buttonGift.setOnClickListener {
            Toast.makeText(this, "This feature is not yet implemented.", Toast.LENGTH_SHORT).show()
        }


    }
}