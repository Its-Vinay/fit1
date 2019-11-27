package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class legs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);
    }


    public void backbutton(View view) {
        onBackPressed();
    }




    public void squats(View view) {
        Intent intent=new Intent(getApplicationContext(),squats.class);
        startActivity(intent);
    }

    public void legpress(View view) {
        Intent intent=new Intent(getApplicationContext(),legpress.class);
        startActivity(intent);
    }

    public void deadliftleg(View view) {
        Intent intent=new Intent(getApplicationContext(),deadliftleg.class);
        startActivity(intent);
    }

    public void lunges(View view) {
        Intent intent=new Intent(getApplicationContext(),lunges.class);
        startActivity(intent);
    }
}
