package com.art.fit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class excercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);




    }
    public void intentEvent(View view) {

        Intent intent;
        switch (view.getId()) {

            case R.id.chest:
                intent = new Intent(getApplicationContext(),chest.class);
                startActivity(intent);
                break;


            case R.id.back:
                intent = new Intent(getApplicationContext(),back.class);
                startActivity(intent);
                break;


            case R.id.biceps:
                intent = new Intent(getApplicationContext(),biceps.class);
                startActivity(intent);
                break;


            case R.id.triceps:
                intent = new Intent(getApplicationContext(),triceps.class);
                startActivity(intent);
                break;


            case R.id.legs:
                intent = new Intent(getApplicationContext(),legs.class);
                startActivity(intent);
                break;

            case R.id.cardio:
                intent = new Intent(getApplicationContext(),cardio.class);
                startActivity(intent);
                break;


            case R.id.shoulders:
                intent = new Intent(getApplicationContext(),shoulders.class);
                startActivity(intent);
                break;

            case R.id.abs:
                intent = new Intent(getApplicationContext(),abs.class);
                startActivity(intent);
                break;

        }
    }

}
