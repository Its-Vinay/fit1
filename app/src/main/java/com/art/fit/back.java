package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

    }

       public void backbutton(View view) {
        onBackPressed();
    }

    public void latpulldown(View view) {
        Intent intent=new Intent(getApplicationContext(),latpulldown.class);
        startActivity(intent);
    }

    public void pullups(View view) {
        Intent intent=new Intent(getApplicationContext(),pullups.class);
        startActivity(intent);
    }

    public void deadlift(View view) {
        Intent intent=new Intent(getApplicationContext(),deadlift.class);
        startActivity(intent);
    }

    public void barbellrow(View view) {
        Intent intent=new Intent(getApplicationContext(),barbellrow.class);
        startActivity(intent);
    }
}
