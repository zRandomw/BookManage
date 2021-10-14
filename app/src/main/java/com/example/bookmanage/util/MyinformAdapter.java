package com.example.bookmanage.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanage.R;
import com.example.bookmanage.bean.Myinform;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyinformAdapter extends RecyclerView.Adapter<MyinformAdapter.ViewHolder> {
    private final List<Myinform> myinforms;

    public MyinformAdapter(List<Myinform> myinforms) {
        this.myinforms = myinforms;
    }

    @NonNull
    @NotNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.r_item_inform,parent,false);
        ViewHolder holder = new ViewHolder(view);
        holder.m_btn.setOnClickListener(v-> holder.m_btn.setText("已查看"));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Myinform myinform = myinforms.get(position);
        holder.bookimg.setImageResource(R.drawable.ic_launcher_background);
        holder.bookname.setText(myinform.getBookName());
        holder.sendtime.setText(myinform.getSendTime());
        holder.manage.setText(myinform.getManage());
    }

    @Override
    public int getItemCount() {
        return myinforms.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookname,sendtime,manage;
        ImageView bookimg;
        Button m_btn;
        public ViewHolder(@NonNull @NotNull View view) {
            super(view);
            bookimg=view.findViewById(R.id.bookimg);
            bookname=view.findViewById(R.id.m_bookname);
            sendtime=view.findViewById(R.id.sendTime);
            manage=view.findViewById(R.id.manage);
            m_btn=view.findViewById(R.id.m_btn);
        }
    }
}
