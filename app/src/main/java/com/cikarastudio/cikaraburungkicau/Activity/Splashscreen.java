package com.cikarastudio.cikaraburungkicau.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cikarastudio.cikaraburungkicau.R;

public class Splashscreen extends AppCompatActivity {

    private ImageView logo;
    private int loadingTime = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        logo = findViewById(R.id.logo_cikara);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke intro activity
                Intent home = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        }, loadingTime);

        Animation myanim = AnimationUtils.loadAnimation(Splashscreen.this, R.anim.splashanimation);
        logo.startAnimation(myanim);

    }
}
