package com.example.examplelist.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.examplelist.R;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        int no = getIntent().getIntExtra("no",0);
        TextView tv = findViewById(R.id.tv_no);
        tv.setText(String.valueOf(no));
    }
}