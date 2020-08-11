package com.example.tluapp.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tluapp.Entities.Status;
import com.example.tluapp.R;
import com.example.tluapp.adapter.StatusAdapter;
import com.example.tluapp.retrofit.ApiUntils;
import com.example.tluapp.retrofit.CMService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCommunity extends AppCompatActivity {

    private CMService cmService;
    ListView listView;
    private StatusAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_status);

        cmService = ApiUntils.getCMService();
        ListView listView = findViewById(R.id.lsv_status);
        adapter = new StatusAdapter(new ArrayList<Status>());
        listView.setAdapter(adapter);
        loadStatus();
        //List<Status> list = requestAPI.getListStatus();
        //list.forEach(System.out::println);

        //StatusAdapter adapter = new StatusAdapter(list);
        //listView = findViewById(R.id.lsv_status);
        //listView.setAdapter(adapter)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ViewComment.class);
                intent.putExtra("id", id);
                System.out.println("idddddddddddddd: " + id);
                startActivity(intent);
            }
        });
    }

    public void loadStatus(){
        cmService.getListStatus().enqueue(new Callback<List<Status>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Status>> call, Response<List<Status>> response) {
                if (response.isSuccessful()){
                    adapter.updateStatus(response.body().stream().collect(Collectors.toList()));
                    Log.d("MainActivity", "posts loaded from API");
                    response.body().forEach(System.out::println);
                }
            }

            @Override
            public void onFailure(Call<List<Status>> call, Throwable t) {

            }
        });
    }
}
