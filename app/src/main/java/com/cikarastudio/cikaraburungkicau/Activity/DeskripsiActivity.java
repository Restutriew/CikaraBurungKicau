package com.cikarastudio.cikaraburungkicau.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cikarastudio.cikaraburungkicau.Model.Burung;
import com.cikarastudio.cikaraburungkicau.R;

public class DeskripsiActivity extends AppCompatActivity {
    public static final String EXTRA_MASSAGE = "extra_burung";
    MediaPlayer mediaPlayer;
    int audiojadi,paused;
    ImageView img_kicauMute, img_kicauPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        TextView tv_judul = findViewById(R.id.tv_judul);
        TextView tv_deskripsi = findViewById(R.id.tv_deskripsi);
        ImageView img_deskripsi = findViewById(R.id.img_deskripsi);
        img_kicauMute = findViewById(R.id.img_kicauMute);
        img_kicauPlay = findViewById(R.id.img_kicauPlay);
        Button btn_suaraBurung = findViewById(R.id.btn_suaraBurung);

        Burung burung = getIntent().getParcelableExtra(EXTRA_MASSAGE);
        String title = burung.getNamaBurung();
        String deskripsi = burung.getDeskripsiBurung();
        int photo = burung.getFotoBurung();
        int audio = burung.getAudioBurung();
        audiojadi = audio;

        tv_judul.setText(title);
        tv_deskripsi.setText(deskripsi);
        img_deskripsi.setImageResource(photo);
        btn_suaraBurung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAudio();
            }
        });
    }


    public void onBackPressed(){
        stopAudio();
        finish();
    }

    private void stopAudio() {
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void startAudio() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, audiojadi);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            img_kicauMute.setVisibility(View.INVISIBLE);
            img_kicauPlay.setVisibility(View.VISIBLE);
        } else if (!mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(paused);
            mediaPlayer.start();
            img_kicauPlay.setVisibility(View.VISIBLE);
            img_kicauMute.setVisibility(View.INVISIBLE);
        } else if (mediaPlayer != null) {
            mediaPlayer.pause();
            paused = mediaPlayer.getCurrentPosition();
            img_kicauMute.setVisibility(View.VISIBLE);
            img_kicauPlay.setVisibility(View.INVISIBLE);
        }
    }


}