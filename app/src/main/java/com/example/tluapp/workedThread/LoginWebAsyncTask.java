package com.example.tluapp.workedThread;

import android.os.AsyncTask;
import com.example.tluapp.Entities.SubjectMark;
import com.example.tluapp.init.Init;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

import java.util.Map;

public class LoginWebAsyncTask extends AsyncTask<Void,Void, Map<String, String>> {
    String[] info;

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";

    Map<String, String> cookie;

    public LoginWebAsyncTask(String[] info) {
        this.info = info;
    }

    @Override
    protected Map<String, String> doInBackground(Void... voids) {
        Init init = new Init();
        String urlLogin = "http://dkh.tlu.edu.vn/CMCSoft.IU.Web.info/login.aspx";
        //go to login page
        Connection.Response loginFormResponse = null;
        try {
            loginFormResponse = Jsoup.connect(urlLogin)
                    .method(Connection.Method.GET)
                    .userAgent(USER_AGENT)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //fill form login
        //#find form login
        FormElement loginForm = null;
        try {
            loginForm = (FormElement) loginFormResponse.parse().select("form#Form1").first();
        } catch (IOException e) {
            e.printStackTrace();
        }
        init.checkElement("login form", loginForm);
        //type userName
        Element userName = loginForm.select("input#txtUserName").first();
        init.checkElement("username", userName);
        userName.val(String.valueOf(info[0]));
        //type password
        Element password = loginForm.select("input#txtPassword").first();
        init.checkElement("password", password);
        try {
            password.val(init.getMD5(String.valueOf(info[1])));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //send form login

        try {
            Connection.Response loginActionResponse = loginForm.submit().cookies(loginFormResponse.cookies())
                    .userAgent(USER_AGENT)
                    .execute();
            cookie = loginActionResponse.cookies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookie;
    }
}
