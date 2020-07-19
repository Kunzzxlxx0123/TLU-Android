package com.example.tluapp.retrofit;

import com.example.tluapp.Entities.Comment;
import com.example.tluapp.Entities.Status;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CMService {
    @GET("/status")
    Call<List<Status>> getListStatus();
    @GET("/status/{statusId}")
    Call<Status> getStatusById(@Path("statusId") int id);
    @POST("/status")
    Call<Status> createStatus(@Body Status status);
    @GET("/status/{statusId}/comment")
    Call<List<Comment>> getListCommentByStatusId(@Path("statusId") int id);
    @POST("/status/{statusId}/comment")
    Call<Comment> createCommentById(@Path("statusId") int id, @Body Comment comment);
}
