package com.example.tluapp.retrofit;

public class ApiUntils {

    public static final String BASE_URL = "https://apirest-tlu.herokuapp.com";

    public static CMService getCMService(){
        return RetrofitClient.getClient(BASE_URL).create(CMService.class);
    }
}
