
package com.example.practical6_5b_6_22012022013

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var playAudio: FloatingActionButton = findViewById<FloatingActionButton>(R.id.play);
        playAudio.setOnClickListener { play() }
        var stopAudio: FloatingActionButton = findViewById<FloatingActionButton>(R.id.stop);
        stopAudio.setOnClickListener { pause() };


    }

    fun play() {
        Intent(applicationContext, MyService::class.java).putExtra(
            MyService.PLAYERKEY,
            MyService.PLAYERVALUE
        ).apply { startService(this) }

    }

    fun pause() {
        Intent(applicationContext, MyService::class.java).putExtra(
            MyService.PLAYERKEY,
            MyService.PLAYERVALUE
        ).apply { stopService(this) }

    }
}

