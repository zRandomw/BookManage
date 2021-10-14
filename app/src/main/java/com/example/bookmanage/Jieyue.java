package com.example.bookmanage;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmanage.bean.AllLoanBook;
import com.example.bookmanage.bean.Loan;
import com.example.bookmanage.util.HttpUtil;
import com.example.bookmanage.util.LoanAdapater;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Jieyue extends AppCompatActivity {
    private static final String TAG = "Jieyue";
    ListView listView;
    List<Loan> loans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jieyue);
        Log.d(TAG, "onCreate: "+BookMain.user.getId());
        listView=findViewById(R.id.list_view);
        fill();
    }
    public void fill(){
        HttpUtil.sendOKHttpPostRequest3("http://10.0.2.2:8080/MyLoan?type=findLoanBook", BookMain.user.getId(), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                String data = Objects.requireNonNull(response.body()).string();
                Log.d(TAG, "onResponse: "+data);
                AllLoanBook allLoanBook=new Gson().fromJson(data,AllLoanBook.class);
                loans= allLoanBook.getData();
                Log.d(TAG, "onResponse: "+loans.get(0).getLoanTime());
                runOnUiThread(()-> filldata(loans));
            }
        });
    }
    public void filldata(List<Loan> loans){
        LoanAdapater loanAdapater = new LoanAdapater(this, R.layout.l_item, loans);
        listView.setAdapter(loanAdapater);

    }
}