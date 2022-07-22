package com.ng.bankly;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ng.bankly.R;
import com.ng.bankly.utils.HttpUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ListView transactionListView;
    private ToggleButton toggleButton;
    private List<TransactionModel> mainTransactionModelList,originalModelList;
    private static final String LOG_TAG = HttpUtils.class.getSimpleName();
    private final static String BASE_URL = "https://res.cloudinary.com/afamo/raw/upload/v1658435016/jsonformatter_nn9swl.txt";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transactionListView = (ListView) findViewById(R.id.idLVtransactions);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        originalModelList = mainTransactionModelList;
        //toggleButton.setOnClickListener(new View.OnClickListener(){

        //});

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void refreshListAfterToggle(View view) {
        String statusName = "Successful";
        if (toggleButton.getTextOn().equals(toggleButton.getText())) {
            String finalStatusName = statusName;
            mainTransactionModelList=  originalModelList.stream().filter((transactionModel)->transactionModel.statusName.equalsIgnoreCase(finalStatusName)).collect(Collectors.toList());
        }
        else{
            //filter by all statuses: failure, successfull,..
            mainTransactionModelList = originalModelList;
            }
        TransactionLVAdapter transactionLVAdapter = new TransactionLVAdapter(MainActivity.this, mainTransactionModelList);
        transactionListView.setAdapter(transactionLVAdapter);
        Toast.makeText(this, "You toggled to view status :"+toggleButton.getText(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (getNetWorkInfor()!=null){
            TransactionTaskRunner TransactionTaskRunnerRunner = new TransactionTaskRunner();
            TransactionTaskRunnerRunner.execute(BASE_URL);
        }
        else {
            Toast.makeText(this, "OOOps!\nIt seems that you don't have data connection", Toast.LENGTH_SHORT).show();
        }

    }
    public NetworkInfo getNetWorkInfor(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();

    }
    private class TransactionTaskRunner extends AsyncTask<String,Void, List<TransactionModel>>  {
        private ProgressDialog progressDialog;

        @RequiresApi(api = Build.VERSION_CODES.O)
        protected List<TransactionModel> doInBackground(String... params) {

            return new HttpUtils().convertToTransactionModel(HttpUtils.getTransactionInfo(params[0]));
        }

        @Override
        protected void onPostExecute(List<TransactionModel> transactionModelList) {
            // execution of result of Long time consuming operation
            super.onPostExecute(transactionModelList);
            Log.d(LOG_TAG,"After Post Execute, Result=="+transactionModelList);
            progressDialog.dismiss();
            TransactionLVAdapter transactionLVAdapter = new TransactionLVAdapter(MainActivity.this, transactionModelList);
            mainTransactionModelList= transactionModelList;
            originalModelList = mainTransactionModelList; // for filtering purposes when toggling
            transactionListView.setAdapter(transactionLVAdapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "ProgressDialog",
                    "Loading Transactions data.....");
        }

        //@Override
        protected void onProgressUpdate(List<TransactionModel> transactionModelList) {
            TransactionLVAdapter transactionLVAdapter = new TransactionLVAdapter(MainActivity.this, transactionModelList);
            transactionListView.setAdapter(transactionLVAdapter);
        }

    }

}


