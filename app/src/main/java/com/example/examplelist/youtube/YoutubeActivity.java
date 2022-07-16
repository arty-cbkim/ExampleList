package com.example.examplelist.youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.example.examplelist.R;
public class YoutubeActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private String API_KEY = "AIzaSyCA42kGOFDI9j_3_bw7BUWOayr1Atk2Pho";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        String video = "https://www.youtube.com/watch?v=dmrlsRckc1s&t=62s";
        String videoId = "dmrlsRckc1s";
    }
}