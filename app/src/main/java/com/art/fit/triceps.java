package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class triceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);
    }


    public void backbutton(View view) {
        onBackPressed();
    }

    public void diamondpushups(View view) {
        Intent intent=new Intent(getApplicationContext(),diamondpushups.class);
        startActivity(intent);
    }

    public void kickback(View view) {
        Intent intent=new Intent(getApplicationContext(),kickback.class);
        startActivity(intent);
    }

    public void skullcrushers(View view) {
        Intent intent=new Intent(getApplicationContext(),skullcrushers.class);
        startActivity(intent);
    }

    public void dips(View view) {
        Intent intent=new Intent(getApplicationContext(),dips.class);
        startActivity(intent);
    }



}
