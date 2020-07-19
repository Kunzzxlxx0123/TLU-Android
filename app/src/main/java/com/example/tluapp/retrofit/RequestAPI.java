package com.example.tluapp.retrofit;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.tluapp.Entities.Status;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestAPI {

    private static CMService cmService;
    public RequestAPI(CMService cmService){
        this.cmService = cmService;
    }
    public static void getListStatus(){
        cmService.getListStatus().enqueue(new Callback<List<Status>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Status>> call, Response<List<Status>> response) {

                System.out.println("statusssssssssssss");
                if (response.isSuccessful()){
                    Log.d("getListStatusSuccess", "onResponse() returned: " + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<List<Status>> call, Throwable t) {
                Log.d("ComunityView", "onFailure: error loading form API");
            }
        });
    }

    public static void getStatusById(int statusId){
        cmService.getStatusById(statusId).enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (response.isSuccessful()){
                    Log.d("", "onResponse: " + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.d("ComunityView", "onFailure: error loading form API");
            }
        });
    }

    public void createStatus(Status status){
        cmService.createStatus(status).enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (response.isSuccessful())
                    Log.d("createStatusSuccess", "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Log.d("ComunityView", "onFailure: error loading form API");
            }
        });
    }
}
