package com.example.tp_android_brunofernandes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_android_brunofernandes.databinding.ActivityMainBinding


class splashscreen : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent( this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
    }
}