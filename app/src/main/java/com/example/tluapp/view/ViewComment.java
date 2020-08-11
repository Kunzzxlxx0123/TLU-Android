package com.example.tluapp.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tluapp.Entities.Comment;
import com.example.tluapp.R;
import com.example.tluapp.adapter.CommentAdapter;
import com.example.tluapp.retrofit.ApiUntils;
import com.example.tluapp.retrofit.CMService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewComment extends AppCompatActivity {
    private CMService cmService;
    ListView listView;
    private CommentAdapter commentAdaper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comment);

        cmService = ApiUntils.getCMService();
        listView = findViewById(R.id.lsv_comment);
        commentAdaper = new CommentAdapter(new ArrayList<Comment>());
        listView.setAdapter(commentAdaper);
        loadComment();
    }

    public void loadComment(){
        cmService.getListCommentByStatusId(new Intent().getIntExtra("id", 1)).enqueue(new Callback<List<Comment>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()){
                    commentAdaper.updateComment(response.body().stream().collect(Collectors.toList()));
                    response.body().forEach(System.out::println);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}
