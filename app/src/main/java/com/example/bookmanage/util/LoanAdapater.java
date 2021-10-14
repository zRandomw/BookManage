package com.example.bookmanage.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookmanage.R;
import com.example.bookmanage.bean.Loan;

import java.util.List;

public class LoanAdapater extends ArrayAdapter<Loan> {
    private int resource;

    public LoanAdapater(@NonNull Context context, int resource, @NonNull List<Loan> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    class ViewHolder{
        TextView bookname,returntime,loantime;
}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Loan loan=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resource,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.bookname=view.findViewById(R.id.L_bookname);
            viewHolder.loantime=view.findViewById(R.id.loantime);
            viewHolder.returntime=view.findViewById(R.id.L_returntime);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.bookname.setText(loan.getBookName());
        viewHolder.loantime.setText(loan.getLoanTime());
        viewHolder.returntime.setText(loan.getReturnTime());
        return view;
    }
}
