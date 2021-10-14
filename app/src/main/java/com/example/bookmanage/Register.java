package com.example.bookmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmanage.bean.Messge;
import com.example.bookmanage.util.HttpUtil;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Register extends AppCompatActivity {
    EditText re_name,re_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        re_name=findViewById(R.id.re_name);
        re_pass=findViewById(R.id.re_pass);
        Button button=findViewById(R.id.register_btn);
        button.setOnClickListener(v-> HttpUtil.sendOKHttpPostRequest("http://10.0.2.2:8080/UserServlet?type=addUser", re_name.getText().toString(), re_pass.getText().toString(), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (register(Objects.requireNonNull(response.body()).string())){
                    runOnUiThread(()-> Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show());
                }else {
                    runOnUiThread(()-> Toast.makeText(Register.this,"注册失败",Toast.LENGTH_SHORT).show());
                }
            }
        }));
    }
    private boolean register(String data) {
        Messge messge=new Gson().fromJson(data, Messge.class);
        return messge.getMessage().equals("yes");
    }
}