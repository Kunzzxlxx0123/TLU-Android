package com.example.tluapp.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tluapp.Entities.SubjectMark;
import com.example.tluapp.R;
import com.example.tluapp.adapter.MarkListViewAdapter;

import java.io.Console;
import java.util.ArrayList;

public class ViewSubMark extends AppCompatActivity {


    ListView listViewMark;
    MarkListViewAdapter markListViewAdapter;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sub_mark);

        Intent intent = getIntent();
        ArrayList<SubjectMark> list = (ArrayList<SubjectMark>) intent.getSerializableExtra("list");

        MarkListViewAdapter markListViewAdapter = new MarkListViewAdapter(list);


        listViewMark = findViewById(R.id.lsv_mark);
        listViewMark.setAdapter(markListViewAdapter);
    }
}
