package com.example.examplelist.multiImagerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examplelist.R;

import java.util.ArrayList;

public class MultiImageRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<String> list;
    ParentAdapter parentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_image_recycler);

        list = new ArrayList<>();
        
        createData();

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager  layoutManager
                = new LinearLayoutManager(MultiImageRecyclerActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        parentAdapter = new ParentAdapter(list, this);

        recyclerView.setAdapter(parentAdapter);
    }
    
    private void createData() {
        for(int i = 1; i<13;i++) {
            list.add(i + "월");
        }
    }
}