package com.didar.sample;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.didar.extendedrecyclerview.Callback;
import com.didar.extendedrecyclerview.ExtendedRecyclerViewAdapter;

import java.util.List;

public class MyAdapterJava extends ExtendedRecyclerViewAdapter {
    List<Integer> list;

    public MyAdapterJava(int layout, List<Integer> list, Callback callback) {
        super(layout, list, callback);
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;

        TextView textView = view.findViewById(R.id.textView);
        textView.setText(list.get(i).toString());
    }
}
