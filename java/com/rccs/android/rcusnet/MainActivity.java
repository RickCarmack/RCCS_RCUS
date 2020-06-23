package com.rccs.android.rcusnet;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_history = (Button) findViewById(R.id.history);
        button_history.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent historyIntent = new Intent(MainActivity.this, historyActivity.class);
                startActivity(historyIntent);
            }
        });
        Button button_congregations = (Button) findViewById(R.id.congregations);
        button_congregations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent congregationsIntent = new Intent(MainActivity.this, congregationsActivity.class);
                startActivity(congregationsIntent);
            }
        });
        Button button_creeds = (Button) findViewById(R.id.creeds);
        button_creeds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent creedsIntent = new Intent(MainActivity.this, creedsActivity.class);
                startActivity(creedsIntent);
            }
        });
        Button button_confessions = (Button) findViewById(R.id.confessions);
        button_confessions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent confessionsIntent = new Intent(MainActivity.this, confessionsActivity.class);
                startActivity(confessionsIntent);
            }
        });
        Button button_sermons = (Button) findViewById(R.id.sermons);
        button_sermons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent sermonsIntent = new Intent(MainActivity.this, holinessActivity.class);
                startActivity(sermonsIntent);
            }
        });
        Button button_reformed = (Button) findViewById(R.id.reformed);
        button_reformed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent reformedIntent = new Intent(MainActivity.this, reformed.class);
                startActivity(reformedIntent);
            }
        });

        mp = MediaPlayer.create(context, R.raw.a_mighty_fortress_is_our_god);

        final Button b = (Button) findViewById(R.id.music);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (mp.isPlaying()) {
                        mp.pause();
                    } else {
                        mp.start();
                    }

            }
        });
    }
    protected void onPause() {
        super.onPause();
        mp.stop();
        mp.reset();
    }

}
