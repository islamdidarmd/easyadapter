package com.didar.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.didar.extendedrecyclerview.Callback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MyAdapter adapter = new MyAdapter(R.layout.row_list, list,
                new Callback() {
                    @Override
                    public void onClick(int position, @NotNull View view, @NotNull Object item) {
                        Integer i = (Integer) item;
                        Log.d(TAG, "onClick: clicked " + i);
                    }

                    @Override
                    public void onLongClick(int position, @NotNull View view, @NotNull Object item) {
                        Integer i = (Integer) item;
                        Log.d(TAG, "onLongClick: onLongClick " + i);
                    }

                    @Override
                    public void onDataSetChanged(int newDataSetSize, @NotNull List<?> newDataSet) {
                        //when you call Adapter.updateDataSet you will get new dataset with size here
                    }
                });

        recyclerView.setAdapter(adapter);

    }
}
