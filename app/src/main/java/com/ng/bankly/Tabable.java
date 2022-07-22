package com.ng.bankly;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.ng.bankly.utils.HttpUtils;

import java.util.List;

public interface Tabable  {


    public static final String LOG_TAG = HttpUtils.class.getSimpleName();
    public final static String BASE_URL = "https://res.cloudinary.com/afamo/raw/upload/v1658392599/jsonformatter_dhdnhk.txt";

    public default void loadTransactions(Context context, ListView transactionListView){
        if (this.getNetWorkInfor()!=null){
            TransactionTaskRunner TransactionTaskRunnerRunner = new TransactionTaskRunner(context,transactionListView);
            TransactionTaskRunnerRunner.execute(BASE_URL);
        }
        else {
            Toast.makeText(context, "OOOps!\nUnable load the transactions data from remote service.\nIt seems that you don't have internet/data connection. ", Toast.LENGTH_LONG).show();
        }

    }

    public  NetworkInfo getNetWorkInfor();

    public class TransactionTaskRunner extends AsyncTask<String,Void, List<TransactionModel>> {
        private ProgressDialog progressDialog;
        private Context context;
        private ListView transactionListView;
        public TransactionTaskRunner(Context context, ListView transactionListView){
            this.context = context;
            this.transactionListView = transactionListView;
        }
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
            TransactionLVAdapter transactionLVAdapter = new TransactionLVAdapter(context, transactionModelList);
            transactionListView.setAdapter(transactionLVAdapter);
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context,
                    "ProgressDialog",
                    "Loading Transactions data.....");
        }

        //@Override
        protected void onProgressUpdate(List<TransactionModel> transactionModelList) {
            TransactionLVAdapter transactionLVAdapter = new TransactionLVAdapter(context, transactionModelList);
            transactionListView.setAdapter(transactionLVAdapter);
        }

    }
}
