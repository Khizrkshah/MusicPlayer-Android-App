package com.example.music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {

    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Intent intent = getIntent();
        int songPos = intent.getIntExtra("pos",0);
        ArrayList<File> mySongs = (ArrayList<File>) intent.getSerializableExtra("songs");
        music = MediaPlayer.create(MusicPlayer.this, Uri.parse(mySongs.get(songPos).getAbsolutePath()));
    }


    public void musicplay(View v)
    {
        music.start();
    }

    public void musicpause(View v)
    {
        music.pause();
    }

    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(MusicPlayer.this, R.raw.stjamessong);
    }
}