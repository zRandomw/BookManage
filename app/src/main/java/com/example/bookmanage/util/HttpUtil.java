package com.example.bookmanage.util;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    public static void sendOKHttpRequest(final String address,okhttp3.Callback callback){
        try {
            OkHttpClient client = new OkHttpClient();
            Request request=new Request.Builder().url(address).build();
            client.newCall(request).enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendOKHttpPostRequest(final String address,String userName,String userPassword,okhttp3.Callback callback){
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody=new FormBody.Builder().add("userName",userName).add("userPass",userPassword).build();
            Request request=new Request.Builder().url(address).post(requestBody).build();
            client.newCall(request).enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendOKHttpPostRequest2(final String address,String bookId,String userId,okhttp3.Callback callback){
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody=new FormBody.Builder().add("bookId",bookId).add("userId",userId).build();
            Request request=new Request.Builder().url(address).post(requestBody).build();
            client.newCall(request).enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendOKHttpPostRequest3(final String address,String userId,okhttp3.Callback callback){
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody=new FormBody.Builder().add("userId",userId).build();
            Request request=new Request.Builder().url(address).post(requestBody).build();
            client.newCall(request).enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
