package com.example.musik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;

public class songView extends AppCompatActivity {


    ImageButton image;
    private double startTime = 0;
    private double finalTime = 0;
    private boolean check = false;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView tx,tx1;
    AudioManager audioManager;
    String g = "";
    public  int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_view);
        tx = (TextView)findViewById(R.id.timeLeft);
        tx1 = (TextView)findViewById(R.id.timeTotal);
        seekbar = (SeekBar)findViewById(R.id.seekBar2);
        if(m.mu != null && m.mu.isPlaying())
            m.mu.reset();
        if( getIntent().getExtras() != null)
        {
            g = getIntent().getStringExtra("index");

            switch (g){
                case "one":
                    image = (ImageButton)findViewById(R.id.albumArt);
                    image.setBackgroundResource(R.drawable.st);
                    ((TextView)findViewById(R.id.songTitle)).setText(R.string.song1);
                    ((TextView)findViewById(R.id.albumname)).setText(R.string.alb1);
                    m.mu = MediaPlayer.create(this, R.raw.song1);
                    tx.setText("0:0");
                    finalTime = m.mu.getDuration();
                    tx1.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) finalTime),TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
                    seekbar.setMax((int) (finalTime/1000));
                    play();

                    break;
                case "two":
                    image = (ImageButton)findViewById(R.id.albumArt);
                    image.setBackgroundResource(R.drawable.st2);
                    ((TextView)findViewById(R.id.songTitle)).setText(R.string.song2);
                    ((TextView)findViewById(R.id.albumname)).setText(R.string.alb2);
                    m.mu = MediaPlayer.create(this, R.raw.song2);tx.setText("0:0");
                    finalTime = m.mu.getDuration();
                    tx1.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) finalTime),TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            finalTime))));
                    seekbar.setMax((int) (finalTime/1000));
                    play();
                    break;
                case "three":
                    image = (ImageButton)findViewById(R.id.albumArt);
                    image.setBackgroundResource(R.drawable.st3);
                    ((TextView)findViewById(R.id.songTitle)).setText(R.string.song3);
                    ((TextView)findViewById(R.id.albumname)).setText(R.string.alb3);
                    m.mu = MediaPlayer.create(this, R.raw.song3);tx.setText("0:0");
                    finalTime = m.mu.getDuration();
                    tx1.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) finalTime),TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            finalTime))));
                    seekbar.setMax((int) (finalTime/1000));
                    play();
                    break;
                case "four":
                    image = (ImageButton)findViewById(R.id.albumArt);
                    image.setBackgroundResource(R.drawable.st4);
                    ((TextView)findViewById(R.id.songTitle)).setText(R.string.song4);
                    ((TextView)findViewById(R.id.albumname)).setText(R.string.alb4);
                    m.mu = MediaPlayer.create(this, R.raw.song4);tx.setText("0:0");
                    finalTime = m.mu.getDuration();
                    tx1.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) finalTime),TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            finalTime))));
                    seekbar.setMax((int) (finalTime/1000));
                    play();
                    break;
                case "five":
                    image = (ImageButton)findViewById(R.id.albumArt);
                    image.setBackgroundResource(R.drawable.st5);
                    ((TextView)findViewById(R.id.songTitle)).setText(R.string.song5);
                    ((TextView)findViewById(R.id.albumname)).setText(R.string.alb5);
                    m.mu = MediaPlayer.create(this, R.raw.song5);tx.setText("0:0");
                    finalTime = m.mu.getDuration();
                    tx1.setText(String.format("%d:%d",TimeUnit.MILLISECONDS.toMinutes((long) finalTime),TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            finalTime))));
                    seekbar.setMax((int) (finalTime/1000));
                    play();
                    break;

            }}
        ((Button)findViewById(R.id.play)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                }
        });
        ((Button)findViewById(R.id.forward)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp+forwardTime)<=finalTime){
                    startTime = startTime + forwardTime;
                    m.mu.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"Forwarded 5 seconds",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Cannot forward 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ((Button)findViewById(R.id.rewind)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int)startTime;

                if((temp-backwardTime)>0){
                    startTime = startTime - backwardTime;
                    m.mu.seekTo((int) startTime);
                    Toast.makeText(getApplicationContext(),"Backwards 5 seconds",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Cannot rewind 5 seconds",Toast.LENGTH_SHORT).show();
                }
            }
        });
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        ((Button)findViewById(R.id.volup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                Toast.makeText(getApplicationContext(), "Volume increased", Toast.LENGTH_SHORT).show();


            }
        });
        ((Button)findViewById(R.id.volDown)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                Toast.makeText(getApplicationContext(), "Volume decreased", Toast.LENGTH_SHORT).show();


            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(m.mu != null && fromUser){
                    m.mu.seekTo(progress);
                }
            }
        });

    }
   public void play() {
       if (m.mu == null) {
           Toast.makeText(getApplicationContext(), "Select A song", Toast.LENGTH_SHORT).show();
           return;

       }
       if (check == true) {
           m.mu.pause();
           ((Button) findViewById(R.id.play)).setBackgroundResource(R.drawable.play);
           check = false;
       } else {
           check = true;
           ((Button) findViewById(R.id.play)).setBackgroundResource(R.drawable.pause);
           m.mu.start();

           startTime = m.mu.getCurrentPosition();

           if (oneTimeOnly == 0) {
               seekbar.setMax((int) finalTime);
               oneTimeOnly = 1;
           }


           tx.setText(String.format("%d:%d",
                   TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                   TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                           TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                   startTime)))
           );

           seekbar.setProgress((int) startTime);
           myHandler.postDelayed(UpdateSongTime1, 100);


       }
   }

    private Runnable UpdateSongTime1 = new Runnable() {
        public void run() {
            startTime = m.mu.getCurrentPosition();
            tx.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
