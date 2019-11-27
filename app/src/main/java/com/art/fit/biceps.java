package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class biceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);
    }

    public void backbutton(View view) {
        onBackPressed();
    }

    public void hammercurls(View view) {
        Intent intent=new Intent(getApplicationContext(),hammercurls.class);
        startActivity(intent);
    }

    public void  barbellcurls(View view) {
        Intent intent=new Intent(getApplicationContext(),barbellcurls.class);
        startActivity(intent);
    }

    public void ezcurls(View view) {
        Intent intent=new Intent(getApplicationContext(),ezcurls.class);
        startActivity(intent);
    }

    public void preachercurls(View view) {
        Intent intent=new Intent(getApplicationContext(),preachercurls.class);
        startActivity(intent);
    }
}
