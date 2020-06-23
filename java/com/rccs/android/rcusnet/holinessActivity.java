package com.rccs.android.rcusnet;

import android.content.Context;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import static android.media.AudioManager.STREAM_MUSIC;

public class holinessActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    Context context = this;
    MediaPlayer mp;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_list);
        mp = new MediaPlayer();
        mp.setAudioStreamType(STREAM_MUSIC);

        // data to populate the RecyclerView with
        ArrayList<String> sermonNames = new ArrayList<>();
        sermonNames.add("The Importance of Holiness");
        sermonNames.add("The Trauma of Holiness");
        sermonNames.add("Holiness and Justice");
        sermonNames.add("The Insanity of Luther");
        sermonNames.add("The Meaning of Holiness");
        sermonNames.add("The Holiness of Christ");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvSermons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, sermonNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        }

        protected void onPause() {
            super.onPause();
            mp.stop();
            mp.reset();
        }


        public void onItemClick(View view, int position) throws IOException {
        String audioUrl = "";
        /* TODO Add ability to pause and stop audio play */

        if (mp.isPlaying()) {
            mp.stop();
            mp.reset();
        }

        switch (position) {
                case 0:
                    // mp = MediaPlayer.create(context, R.raw.importance_of_holiness);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i01.mp3";
                    mp.setDataSource(audioUrl);
                    break;
                case 1:
                    // mp = MediaPlayer.create(context, R.raw.trauma_of_holiness);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i02.mp3";
                    mp.setDataSource(audioUrl);
                    break;
                case 2:
                    // mp = MediaPlayer.create(context, R.raw.holiness_and_justice);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i03.mp3";
                    mp.setDataSource(audioUrl);
                    break;
                case 3:
                    // mp = MediaPlayer.create(context, R.raw.insanity_of_luther);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i04.mp3";
                    mp.setDataSource(audioUrl);
                    break;
                case 4:
                    // mp = MediaPlayer.create(context, R.raw.meaning_of_holiness);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i05.mp3";
                    mp.setDataSource(audioUrl);
                    break;
                case 5:
                    // mp = MediaPlayer.create(context, R.raw.holiness_of_christ);
                    // mp.start();
                    audioUrl = "https://dqjk5zycp9col.cloudfront.net/series/hol01/mp3/hol01m3i06.mp3";
                    mp.setDataSource(audioUrl);
                    break;
            }

            mp.prepare();
            mp.start();

    }
}
