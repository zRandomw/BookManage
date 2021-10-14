package com.example.bookmanage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmanage.bean.User;
import com.example.bookmanage.util.HttpUtil;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText userName,userpass;
    TextView textView;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login=findViewById(R.id.login);
        userName=findViewById(R.id.username);
        userpass=findViewById(R.id.password);
        textView=findViewById(R.id.register);
        login.setOnClickListener(v->{
            HttpUtil.sendOKHttpPostRequest("http://10.0.2.2:8080/UserServlet?type=login", userName.getText().toString(), userpass.getText().toString(), new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }
                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String data= Objects.requireNonNull(response.body()).string();
                    Log.d(TAG, "onResponse: "+data);
                    if(login(data)){
                        runOnUiThread(()->{
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            MainActivity.this.startActivity(new Intent(MainActivity.this,BookMain.class).putExtra("User",user));
                        });
                        finish();
                    }else {
                        runOnUiThread(()-> Toast.makeText(MainActivity.this,"账号或者密码错误",Toast.LENGTH_SHORT).show());
                    }
                }
            });
        });
        textView.setOnClickListener(v-> startActivity(new Intent(this,Register.class)));
    }
    private boolean login(String data) {
        user=new Gson().fromJson(data, User.class);
        return user.getMessage().equals("yes");
    }
}