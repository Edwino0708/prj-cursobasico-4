package com.example.edwin.proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Presentacion extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentacion);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent in = new Intent(Presentacion.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
