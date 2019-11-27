package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cardio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);
    }


    public void backbutton(View view) {
        onBackPressed();
    }


    public void treadmill(View view) {
        Intent intent=new Intent(getApplicationContext(),treadmill.class);
        startActivity(intent);
    }

    public void elliptical(View view) {
        Intent intent=new Intent(getApplicationContext(),elliptical.class);
        startActivity(intent);
    }

    public void skipping(View view) {
        Intent intent=new Intent(getApplicationContext(),skipping.class);
        startActivity(intent);
    }

    public void jumprope(View view) {
        Intent intent=new Intent(getApplicationContext(),jumprope.class);
        startActivity(intent);
    }
}
