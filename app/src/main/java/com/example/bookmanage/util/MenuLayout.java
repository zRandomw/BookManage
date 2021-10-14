package com.example.bookmanage.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.bookmanage.BookMain;
import com.example.bookmanage.Huanshu;
import com.example.bookmanage.Jieyue;
import com.example.bookmanage.MainActivity;
import com.example.bookmanage.R;

public class MenuLayout extends LinearLayout {
    private static final String TAG = "MenuLayout";
    private static Context BookmainContext;
    public MenuLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.menu,this);
        TextView texttushu=findViewById(R.id.tushu);
        TextView textjieyue=findViewById(R.id.jieyue1);
        TextView texthuanshu=findViewById(R.id.huanshu);
        texttushu.setOnClickListener(v -> {
            Intent intent=new Intent(getContext(), BookMain.class);
            getContext().startActivity(intent);
            if (!(getContext()==BookmainContext)){
                ((Activity)getContext()).finish();
            }
        });
        textjieyue.setOnClickListener(v -> {
            Intent intent=new Intent(getContext(), Jieyue.class);
            getContext().startActivity(intent);
            if (!(getContext()==BookmainContext)){
                ((Activity)getContext()).finish();
            }
        });
        texthuanshu.setOnClickListener(v -> {
            Intent intent=new Intent(getContext(), Huanshu.class);
            getContext().startActivity(intent);
            if (!(getContext()==BookmainContext)){
                ((Activity)getContext()).finish();
            }
        });
    }
    public static void getBookmainContext(Context context){
        BookmainContext=context;
    }
}
