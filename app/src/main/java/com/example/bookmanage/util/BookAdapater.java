package com.example.bookmanage.util;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanage.BookMain;
import com.example.bookmanage.R;
import com.example.bookmanage.bean.Book;
import com.example.bookmanage.bean.Messge;
import com.example.bookmanage.bean.User;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BookAdapater extends RecyclerView.Adapter<BookAdapater.ViewHolder> {
    private List<Book> books;
    private User user;
    private BookMain main;
    private static final String TAG = "BookAdapater";
    public BookAdapater(List<Book> books,User user,BookMain main) {
        this.books = books;
        this.user=user;
        this.main=main;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.r_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.jieyue.setOnClickListener(v->{
            int position=viewHolder.getAdapterPosition();
            Book book = books.get(position);
            Log.d(TAG, "onCreateViewHolder: "+position);
            Log.d(TAG, "onCreateViewHolder: "+book);
            Log.d(TAG, "userid :"+user.getId()+" bookId:"+book.getid());
            jieyue(book.getid(),user.getId());
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bookname.setText(book.getBookName());
        holder.bookinfo.setText(book.getBookInfo());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView  bookname,bookinfo;
        Button jieyue;
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            bookname=view.findViewById(R.id.bookname);
            bookinfo=view.findViewById(R.id.bookinfo);
            jieyue=view.findViewById(R.id.jieyue);
        }
    }
    public void jieyue(Integer bookId,String userId){
        HttpUtil.sendOKHttpPostRequest2("http://10.0.2.2:8080/MyLoan?type=AddLoan", String.valueOf(bookId), userId, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String data = response.body().string();
                Log.d(TAG, "onResponse: "+data);
                Messge messge=new Gson().fromJson(data,Messge.class);
                if (messge.getMessage().equals("yes")){
                    main.runOnUiThread(()->{
                        Toast.makeText(main,"借阅成功",Toast.LENGTH_SHORT).show();
                        main.fillBookdata();
                    });
                }else {
                    main.runOnUiThread(()->{
                        Toast.makeText(main,"借阅失败",Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }
}
