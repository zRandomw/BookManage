package com.example.bookmanage;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanage.bean.AdminAllLoan;
import com.example.bookmanage.bean.Myinform;
import com.example.bookmanage.util.HttpUtil;
import com.example.bookmanage.util.MyinformAdapter;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Huanshu extends AppCompatActivity {
    private static final String TAG = "Huanshu";
    private List<Myinform> myinforms;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanshu);
        recyclerView=findViewById(R.id.re_view2);
        fill();
    }
    public void fill(){
        HttpUtil.sendOKHttpPostRequest3("http://10.0.2.2:8080/MyInForm?type=AdminAllLoan", BookMain.user.getId(), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String data = Objects.requireNonNull(response.body()).string();
                Log.d(TAG, "onResponse: "+data);
                AdminAllLoan adminAllLoan=new Gson().fromJson(data,AdminAllLoan.class);
                myinforms=adminAllLoan.getData();
                runOnUiThread(()-> filldata(myinforms));
            }
        });
    }
    public void filldata(List<Myinform> myinforms){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyinformAdapter myinformAdapter = new MyinformAdapter(myinforms);
        recyclerView.setAdapter(myinformAdapter);
    }
}