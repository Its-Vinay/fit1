package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
    }

    public void backbutton(View view) {
        onBackPressed();
    }

    public void benchpress(View view) {
        Intent intent=new Intent(getApplicationContext(),benchpress.class);
        startActivity(intent);
    }

    public void crossover(View view) {
        Intent intent=new Intent(getApplicationContext(),crossover.class);
        startActivity(intent);
    }

    public void fly(View view) {
        Intent intent=new Intent(getApplicationContext(),fly.class);
        startActivity(intent);
    }

    public void pullover(View view) {
        Intent intent=new Intent(getApplicationContext(),pullover.class);
        startActivity(intent);
    }
}
