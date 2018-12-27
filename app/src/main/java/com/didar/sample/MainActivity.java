package com.didar.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.didar.extendedrecyclerview.Callback;
import com.didar.extendedrecyclerview.EasyAdapter;

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

        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(new EasyAdapter.Builder<Integer>()
                .setLayout(R.layout.row_list)
                .setItemCount(list.size())
                .setData(list).setCallback(new Callback() {
                    @Override
                    public void onBindViewHolder(@NonNull EasyAdapter.Companion.ViewHolder viewHolder, @NonNull View itemView, int position) {
                        //TODO Bind your view Holder here.
                        TextView textView = itemView.findViewById(R.id.textView);
                        textView.setText(list.get(position).toString());
                    }
                }).build());
    }
}
