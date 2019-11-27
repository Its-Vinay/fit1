package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shoulders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulders);

    }

    public void backbutton(View view) {
        onBackPressed();
    }





    public void overheadpress(View view) {
        Intent intent=new Intent(getApplicationContext(),overheadpress.class);
        startActivity(intent);
    }

    public void shrugs(View view) {
        Intent intent=new Intent(getApplicationContext(),shrugs.class);
        startActivity(intent);
    }

    public void reardeltfly(View view) {
        Intent intent=new Intent(getApplicationContext(),reardeltfly.class);
        startActivity(intent);
    }

    public void frontraise(View view) {
        Intent intent=new Intent(getApplicationContext(),frontraise.class);
        startActivity(intent);
    }
}
