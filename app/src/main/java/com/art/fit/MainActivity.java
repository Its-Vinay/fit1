package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    TextView tv_steps;
    Button btnadd,btnremove,btn_reset,btn_train;
    TextView distance,water,calorie;
    int count=0;
    int ref;

    SensorManager sensorManager;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_steps =  findViewById(R.id.tv_steps);

        btnadd       = findViewById(R.id.btn_add);
        btnremove    = findViewById(R.id.btn_remove);
        btn_reset =  findViewById(R.id.btn_reset);
        btn_train = findViewById(R.id.btn_train);
        distance= findViewById(R.id.tv_distance);
        water= findViewById(R.id.tv_water);

        calorie= findViewById(R.id.tv_calories);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        SharedPreferences preferences = getSharedPreferences("STEP_COUNTER_REF",MODE_PRIVATE);
        ref = preferences.getInt("STEP_REF",0);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(v);
            }
        });

        btn_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent;
                intent = new Intent(getApplicationContext(),excercise.class);
                startActivity(intent);
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();
            }
        });



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




    @Override
    public void onSensorChanged(SensorEvent Event) {


        if(running)
        {
            float c = Event.values[0];
            c  -= ref;
            tv_steps.setText(String.valueOf((int)c));
            distance.setText(String.valueOf((c*0.76)));
            calorie.setText(String.valueOf((c*.05)));


        }

    }


        private void reset()
        {
            ref = count;
            count  = 0;
            SharedPreferences.Editor editor = getSharedPreferences("STEP_COUNT_REF",MODE_PRIVATE).edit();
            editor.putInt("STEP_REF",ref);


            tv_steps.setText("0");
            distance.setText("0");
            calorie.setText("0");
            water.setText("0");


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void add(View view) {

        count+=1;
        water.setText(String.valueOf(count));
    }

    public void remove(View view) {

        count-=1;
        water.setText(String.valueOf(count));
    }
}

