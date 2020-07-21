package com.cikarastudio.cikaraburungkicau.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cikarastudio.cikaraburungkicau.R;

public class MainActivity extends AppCompatActivity {
    Button btn_mainMulai,btn_mainPetunjuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_mainMulai = findViewById(R.id.btn_mainMulai);
        btn_mainPetunjuk = findViewById(R.id.btn_mainPetunjuk);

        btn_mainMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnMulai = new Intent(MainActivity.this,ListBurungActivity.class);
                startActivity(btnMulai);
            }
        });

        btn_mainPetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////
            }
        });


    }
}
