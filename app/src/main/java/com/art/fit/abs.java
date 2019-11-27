package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class abs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);
    }
    public void backbutton(View view) {
        onBackPressed();
    }

    public void crunches(View view) {
        Intent intent=new Intent(getApplicationContext(),crunches.class);
        startActivity(intent);
    }

    public void plank(View view) {
        Intent intent=new Intent(getApplicationContext(),plank.class);
        startActivity(intent);
    }

    public void situps(View view) {
        Intent intent=new Intent(getApplicationContext(),situps.class);
        startActivity(intent);
    }

    public void ropecrunches(View view) {
        Intent intent=new Intent(getApplicationContext(),ropecrunches.class);
        startActivity(intent);
    }
}
