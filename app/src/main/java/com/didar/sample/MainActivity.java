package com.didar.sample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.didar.extendedrecyclerview.Callback;
import com.didar.extendedrecyclerview.EasyAdapter;
import com.didar.extendedrecyclerview.EasySectionedAdapter;
import com.didar.extendedrecyclerview.SectionedCallback;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGeneral = findViewById(R.id.btn_general);
        Button btnSectioned = findViewById(R.id.btn_sectioned);

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

        btnSectioned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SectionedRecyclerViewActivity.class));
            }
        });
    }
}
