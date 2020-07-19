package com.example.tluapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tluapp.Entities.SubjectMark;
import com.example.tluapp.Entities.TimeTable;
import com.example.tluapp.view.ViewCommunity;
import com.example.tluapp.view.ViewSubMark;
import com.example.tluapp.view.ViewTimeTable;
import com.example.tluapp.workedThread.SubMarkAsynTask;
import com.example.tluapp.workedThread.TimeTableAsynTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_subMark = findViewById(R.id.btn_subMark);
        Button btn_sche = findViewById(R.id.btn_sche);
        Button btn_exam = findViewById(R.id.btn_exam);


        btn_subMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Lấy cookie từ LoginView
                    Intent getCookie = getIntent();
                    Map<String,String> cookie = (Map<String, String>) getCookie.getSerializableExtra("cookie");

                    // gọi subMarkAsyntask để lấy list Mark
                    SubMarkAsynTask subMarkAsynTask = new SubMarkAsynTask();
                    ArrayList<SubjectMark> list = new ArrayList<>();
                    list = subMarkAsynTask.execute(cookie).get();

                    // đưa list qua ViewSubMark để hiển thị
                    Intent intent = new Intent(getApplicationContext(), ViewSubMark.class);
                    intent.putExtra("list", (Serializable) list);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_sche.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                try {
                    Intent getCookie = getIntent();
                    Map<String, String> cookie = (Map<String, String>) getCookie.getSerializableExtra("cookie");

                    TimeTableAsynTask tableAsynTask = new TimeTableAsynTask();
                    ArrayList<TimeTable> list = new ArrayList<>();
                    list = tableAsynTask.execute(cookie).get();
                    System.out.println("listssssssssssssssss");
                    list.forEach(e -> {
                        System.out.println(e.toString());
                    });

                    Intent intent = new Intent(getApplicationContext(), ViewTimeTable.class);
                    intent.putExtra("list", (Serializable) list);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        btn_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewCommunity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
