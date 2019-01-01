package com.didar.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.didar.extendedrecyclerview.EasyAdapter;
import com.didar.extendedrecyclerview.EasySectionedAdapter;
import com.didar.extendedrecyclerview.SectionedCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionedRecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sectioned RecyclerView");
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(new EasySectionedAdapter.Builder<Integer>()
                .setHeaderLayout(R.layout.row_header)
                .setChildLayout(R.layout.row_list)
                .setDataSet(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2), Arrays.asList(1, 2, 3)))
                .setCallback(new SectionedCallback<Integer>() {
                    @Override
                    public void onBindHeader(@NotNull EasyAdapter.Companion.ViewHolder viewHolder, int section) {
                        viewHolder.itemView.setBackgroundColor(Color.BLACK);
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setTextColor(Color.WHITE);
                        tv.setText("Header");
                    }

                    @Override
                    public void onBindChild(@NotNull EasyAdapter.Companion.ViewHolder viewHolder, int section, int positionInSection, int position, Integer item) {
                        TextView tv = viewHolder.itemView.findViewById(R.id.textView);
                        tv.setText(item.toString());
                        tv.setTextColor(Color.BLACK);
                        viewHolder.itemView.setBackgroundColor(Color.WHITE);
                    }
                })
                .build());
    }
}
