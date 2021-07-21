package com.example.elk

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import kotlinx.android.synthetic.main.activity_media_player.*

class MusicPlay :AppCompatActivity() {
    private  val  mediaPlayer=MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player);
        initMediaPlayer()
        iv_play.setOnClickListener{
            if (!mediaPlayer.isPlaying){
                iv_play.visibility=View.GONE
                iv_pause.visibility= View.VISIBLE
                mediaPlayer.start()
            }
        }
        iv_pause.setOnClickListener{
            if (mediaPlayer.isPlaying){
                iv_play.visibility=View.VISIBLE
                iv_pause.visibility= View.GONE
                mediaPlayer.pause()
            }
        }




    }

    private fun initMediaPlayer() {
        val  assetManager=assets
        val fd=assetManager.openFd("lonely.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor,fd.startOffset,fd.length)
        mediaPlayer.prepare()
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }


}

