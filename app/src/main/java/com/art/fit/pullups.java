package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class pullups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullups);
        TextView textView = findViewById(R.id.pullups1);
        textView.setText(R.string.pullups1);
    }
    public void backbutton(View view) {
        onBackPressed();
    }

    public void startexercise(View view) {
        Intent intent = new Intent(getApplicationContext(), startexercise.class);
        startActivity(intent);
    }
}
