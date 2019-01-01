package com.didar.sample;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.didar.extendedrecyclerview.Callback;
import com.didar.extendedrecyclerview.EasyAdapter;
import com.didar.extendedrecyclerview.EasySectionedAdapter;
import com.didar.extendedrecyclerview.SectionedCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RecyclerView");
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(new EasyAdapter.Builder<Integer>()
                .setLayout(R.layout.row_list)
                .setData(Arrays.asList(1, 2, 3, 4))
                .setCallback(new Callback<Integer>() {
                    @Override
                    public void onBindViewHolder(@NonNull EasyAdapter.Companion.ViewHolder viewHolder, @NonNull View itemView, int position, Integer item) {
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setText(item.toString());
                    }
                })
                .build());
    }
}
