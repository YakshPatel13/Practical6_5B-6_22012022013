package com.example.practical6_5b_6_22012022013
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyService : Service() {
    lateinit var player:MediaPlayer
    companion object{ val PLAYERKEY="Service"
        val PLAYERVALUE="Play/Pause"}
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::player.isInitialized)
        {
            player=MediaPlayer.create(this,R.raw.song)
        }
        if (intent !=null)
        {
            val dataValue=intent.getStringExtra(PLAYERKEY)
            if (dataValue== PLAYERVALUE)
            {
                if (!player.isPlaying)
                {
                    player.start()
                }
                else
                {
                    player.pause()
                }
            }
        }

        else{
            player.stop()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
}