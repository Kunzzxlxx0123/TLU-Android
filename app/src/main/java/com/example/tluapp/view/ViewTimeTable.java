package com.example.tluapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tluapp.Entities.TimeTable;
import com.example.tluapp.R;
import com.example.tluapp.adapter.TimeTableViewAdapter;

import java.util.ArrayList;

public class ViewTimeTable extends AppCompatActivity {

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);

        Intent intent = getIntent();
        ArrayList<TimeTable> list = (ArrayList<TimeTable>) intent.getSerializableExtra("list");
        TimeTableViewAdapter timeTableViewAdapter = new TimeTableViewAdapter(list);

        listView = findViewById(R.id.lsv_timetable);
        listView.setAdapter(timeTableViewAdapter);

    }
}
