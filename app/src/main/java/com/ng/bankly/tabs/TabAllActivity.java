package com.ng.bankly.tabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ListView;

import com.ng.bankly.R;
import com.ng.bankly.Tabable;

public class TabAllActivity extends AppCompatActivity implements Tabable{
    private ListView transactionListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_all);
        transactionListView = (ListView) findViewById(R.id.idLVtransactions);
        loadTransactions(this,transactionListView);

    }

    @Override
    public void loadTransactions(Context context, ListView transactionListView) {
        Tabable.super.loadTransactions(context, transactionListView);
    }

    @Override
    public NetworkInfo getNetWorkInfor() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }
}