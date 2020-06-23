package com.rccs.android.rcusnet;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class reformed extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reformed);

        Button button_objections = (Button) findViewById(R.id.objections);
        button_objections.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent objectionsIntent = new Intent(reformed.this, objections.class);
                startActivity(objectionsIntent);
            }

        });

        Button attributes = (Button) findViewById(R.id.attributes);
        attributes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent attributesIntent = new Intent(reformed.this, attributesActivity.class);
                startActivity(attributesIntent);
            }

        });

    }
}