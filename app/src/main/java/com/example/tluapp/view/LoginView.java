package com.example.tluapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tluapp.MainActivity;
import com.example.tluapp.R;
import com.example.tluapp.workedThread.LoginWebAsyncTask;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class LoginView extends AppCompatActivity {
    EditText txt_userName;
    EditText txt_password;
    Button btn_login;
    TextView txt_notification;
    Map<String,String> cookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        txt_userName = findViewById(R.id.username);
        txt_password = findViewById(R.id.password);
        btn_login = findViewById(R.id.login);
        txt_notification = findViewById(R.id.txt_logintext);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // lấy dữ liêu từ Activity
                    String user = txt_userName.getText().toString();
                    String pass = txt_password.getText().toString();

                    String[] info = {user,pass};

                    // Lấy cookie đăng nhập
                    cookie = (Map<String, String>) new LoginWebAsyncTask(info).execute().get();
                    System.out.println(user);
                    System.out.println(pass);
                    System.out.println("Cookiessssssssssss" + cookie);

                    //Kiểm tra đăng nhập
                    if(cookie.isEmpty()){
                        txt_notification.setText("Sai tai khoan hoac mat khau");
                    } else {
                        // đưa cookie qua main Activity
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("cookie", (Serializable) cookie);
                        startActivity(intent);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });




    }
}
