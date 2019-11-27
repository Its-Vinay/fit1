package com.art.fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class startexercise extends AppCompatActivity {


    private EditText et;
    private TextView tv;
    private Button set;
    private Button start_pause, reset;
    private CountDownTimer countDownTimer;
    private Boolean mtimerRunning;
    private long mstarttimeinmillis;
    private long mlefttimeinmillis;
    private long mendtime;
    private SoundPool soundPool;
    private int sound1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        set = findViewById(R.id.btn_set);
        start_pause = findViewById(R.id.btn_start_pause);
        reset = findViewById(R.id.btn_reset);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .build();
        sound1=soundPool.load(getApplicationContext(),R.raw.timer,1);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(startexercise.this, "Fields can't be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisinput = Long.parseLong(input) * 60000;
                if (millisinput == 0) {
                    Toast.makeText(startexercise.this, "Please enter valid no.", Toast.LENGTH_SHORT).show();
                    return;
                }
                setTime(millisinput);
                et.setText("");

            }
        });

        start_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mtimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();

            }
        });

    }

    private void setTime(long milliseconds) {
        mstarttimeinmillis = milliseconds;
        resetTimer();
        closeKeyboard();
    }

    private void startTimer() {
        mendtime = System.currentTimeMillis() + mlefttimeinmillis;
        countDownTimer = new CountDownTimer(mlefttimeinmillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mlefttimeinmillis = millisUntilFinished;
                updateText();

            }

            @Override
            public void onFinish() {
                mtimerRunning = false;
                updateWatchinterface();
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000);

                soundPool.play(sound1,1,1,0,-1,1);


            }
        }.start();
        mtimerRunning = true;
        updateWatchinterface();

    }

    private void pauseTimer() {
        countDownTimer.cancel();
        mtimerRunning = false;
        updateWatchinterface();


    }

    private void resetTimer() {
        mlefttimeinmillis = mstarttimeinmillis;
        updateText();
        updateWatchinterface();


    }

    private void updateText() {
        int hours = (int) ((mlefttimeinmillis / 1000) / 3600);
        int minutes = (int) ((mlefttimeinmillis / 1000) % 3600) / 60;
        int seconds = (int) ((mlefttimeinmillis / 1000) % 3600) % 60;
        String timeFormat;
        if (hours > 0) {
            timeFormat = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        }
        tv.setText(timeFormat);
    }

    private void updateWatchinterface() {
        if (mtimerRunning) {
            et.setVisibility(View.INVISIBLE);
            set.setVisibility(View.INVISIBLE);
            reset.setVisibility(View.INVISIBLE);
            start_pause.setText("PAUSE");
        } else {
            et.setVisibility(View.VISIBLE);
            set.setVisibility(View.VISIBLE);
            start_pause.setText("START");
            if (mlefttimeinmillis < 1000) {
                start_pause.setVisibility(View.INVISIBLE);

            } else {
                start_pause.setVisibility(View.VISIBLE);
            }
            if (mlefttimeinmillis < mstarttimeinmillis) {
                reset.setVisibility(View.VISIBLE);
            } else {
                reset.setVisibility(View.INVISIBLE);

            }
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences log=getSharedPreferences("log",MODE_PRIVATE);
        SharedPreferences.Editor editor=log.edit();
        editor.putLong("starttimeinmillis",mstarttimeinmillis);
        editor.putLong("millisleft",mlefttimeinmillis);
        editor.putBoolean("timerRunning",mtimerRunning);
        editor.putLong("endtime",mendtime);
        editor.apply();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences log=getSharedPreferences("log",MODE_PRIVATE);
        mstarttimeinmillis=log.getLong("starttimeinmillis",60000);
        mlefttimeinmillis=log.getLong("millisleft",mstarttimeinmillis);
        mtimerRunning=log.getBoolean("timerRunning",false);
        updateText();
        updateWatchinterface();
        if(mtimerRunning){
            mendtime=log.getLong("endtime",0);
            mlefttimeinmillis=mendtime-System.currentTimeMillis();
            if(mlefttimeinmillis<0){
                mlefttimeinmillis=0;
                mtimerRunning=false;
                updateText();
                updateWatchinterface();

            }
            else{
                startTimer();
            }
        }

    }

}