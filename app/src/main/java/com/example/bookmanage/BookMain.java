package com.example.bookmanage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanage.bean.Alldata;
import com.example.bookmanage.bean.Book;
import com.example.bookmanage.bean.User;
import com.example.bookmanage.util.BookAdapater;
import com.example.bookmanage.util.HttpUtil;
import com.example.bookmanage.util.MenuLayout;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BookMain extends AppCompatActivity {
    private static final String TAG = "BookMain";
    RecyclerView recyclerView;
    List<Book> books;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_main);
        MenuLayout.getBookmainContext(this);
        user=(User) getIntent().getSerializableExtra("User");
        Log.d(TAG, "onCreate: "+Thread.currentThread().getName());
        recyclerView=findViewById(R.id.re_view);
        fillBookdata();
        Log.d(TAG, "onCreate: "+books);
//        while (true){
//            if (books!=null){
//                fill(books);
//                break;
//            }
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 销毁");
    }

    public void fillBookdata(){
        HttpUtil.sendOKHttpRequest("http://10.0.2.2:8080/MyBook?type=AllData", new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+Thread.currentThread().getName());
                String data= Objects.requireNonNull(response.body()).string();
                Log.d(TAG, "onResponse: "+data);
                books = getbooklist(data);
                runOnUiThread(()-> {
                    if (books!=null){
                        fill(books);
                    }else {
                        Toast.makeText(BookMain.this,"图书已经借完了",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
    private List<Book> getbooklist(String data) {
        Alldata alldata=new Gson().fromJson(data,Alldata.class);
        return alldata.getData();
    }
    public void fill(List<Book> books){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(BookMain.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        BookAdapater bookAdapater = new BookAdapater(books,user,this);
        recyclerView.setAdapter(bookAdapater);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fillBookdata();
    }
}