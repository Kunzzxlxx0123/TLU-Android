package com.example.tluapp.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.tluapp.Entities.Comment;
import com.example.tluapp.Entities.Status;
import com.example.tluapp.R;
import com.example.tluapp.retrofit.ApiUntils;
import com.example.tluapp.retrofit.CMService;
import com.example.tluapp.retrofit.RequestAPI;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCommunity extends AppCompatActivity {

    private CMService cmService;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_community);

        cmService = ApiUntils.getCMService();
        RequestAPI requestAPI = new RequestAPI(cmService);
        requestAPI.getListStatus();

        requestAPI.createStatus(new Status("Tim nguoi yeu", "Co don qua muon tim nguoi yeu"));

    }
}
