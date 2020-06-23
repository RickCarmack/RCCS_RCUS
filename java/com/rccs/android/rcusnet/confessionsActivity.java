package com.rccs.android.rcusnet;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class confessionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confessions);

        Button button_heidelberg = (Button) findViewById(R.id.heidelberg);
        button_heidelberg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent heidelbergIntent = new Intent(confessionsActivity.this, heidelbergActivity.class);
                startActivity(heidelbergIntent);
            }
        });
        Button button_belgic = (Button) findViewById(R.id.belgic);
        button_belgic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent belgicIntent = new Intent(confessionsActivity.this, belgicActivity.class);
                startActivity(belgicIntent);
            }
        });
        Button button_canons = (Button) findViewById(R.id.canons);
        button_canons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent canonsIntent = new Intent(confessionsActivity.this, canonsActivity.class);
                startActivity(canonsIntent);
            }
        });
        Button button_westminster = (Button) findViewById(R.id.westminster);
        button_westminster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent westminsterIntent = new Intent(confessionsActivity.this, westminsterActivity.class);
                startActivity(westminsterIntent);
            }
        });

    }
}
