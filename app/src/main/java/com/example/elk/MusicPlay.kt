package com.example.elk

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
                //mediaPlayer.seekTo(60)
            }
        }
        iv_pause.setOnClickListener{
            if (mediaPlayer.isPlaying){
                iv_play.visibility=View.VISIBLE
                iv_pause.visibility= View.GONE
                mediaPlayer.pause()
            }else{
                mediaPlayer.start()
            }

        }
        iv_next.setOnClickListener {



            Toast.makeText(this,"曲库只有这一首",Toast.LENGTH_SHORT).show()

        }
        iv_prev.setOnClickListener {
            Toast.makeText(this,"曲库只有这一首",Toast.LENGTH_SHORT).show()

        }




    }

    private fun initMediaPlayer() {
        val  assetManager=assets
        //val fd=assetManager.openFd("lonely.mp3")

        val fd=assetManager.openFd("birthday_song.m4a")

        mediaPlayer.setDataSource(fd.fileDescriptor,fd.startOffset,fd.length)
        mediaPlayer.prepare()

    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }


}

