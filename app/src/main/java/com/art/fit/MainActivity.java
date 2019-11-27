package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    TextView tv_steps;
    Button btnadd,btnremove;
    TextView distance,water,calorie;
    int count=0;

    SensorManager sensorManager;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_steps = (TextView) findViewById(R.id.tv_steps);
        distance=(TextView) findViewById(R.id.tv_steps2);
        water=(TextView) findViewById(R.id.textView2);

        calorie=(TextView) findViewById(R.id.calorie);
        btnadd       = (Button)findViewById(R.id.btnadd);
        btnremove    = (Button)findViewById(R.id.btnremove);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);



    }

    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor!=null)
        {
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);

        }

        else {
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    protected void onPause() {
        super.onPause();
        running=false;
        //SensorManager.unregisterListener(this);
    }



    public void intentEvent(View view) {

        Intent intent;
        switch (view.getId()) {

            case R.id.button:
                intent = new Intent(getApplicationContext(),excercise.class);
                startActivity(intent);

        }
    }

    @Override
    public void onSensorChanged(SensorEvent Event) {


        if(running)
        {
            tv_steps.setText(String.valueOf(Event.values[0]));
            distance.setText(String.valueOf((Event.values[0]*0.000762)));
            calorie.setText(String.valueOf((Event.values[0]*.04)));

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void add(View view) {

        count+=1;
        water.setText(count+"");
    }

    public void remove(View view) {

        count-=1;
        water.setText(count+"");
    }
}

