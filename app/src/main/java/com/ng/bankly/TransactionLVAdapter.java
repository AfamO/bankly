package com.ng.bankly;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ng.bankly.R;

import java.util.List;

public class TransactionLVAdapter extends ArrayAdapter<TransactionModel> {

    public TransactionLVAdapter(@NonNull Context context, List<TransactionModel> transactionModelList) {
        super(context, 0, transactionModelList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //Inflate the transaction_lv_item layout
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.transaction_lv_item, parent, false);
        }

        
        TransactionModel transactionModel = getItem(position);

        // Initialize UI components of list view item.
        TextView transactionTypeName = listitemView.findViewById(R.id.transactionTypeName);
        TextView amount = listitemView.findViewById(R.id.amount);
        TextView transactionDate = listitemView.findViewById(R.id.transactionDate);
        TextView transactionStatus = listitemView.findViewById(R.id.statusName);



        // simply set item to our view
        transactionTypeName.setText(transactionModel.getTransactionTypeName());
        amount.setText(Double.toString(transactionModel.getAmount()));
        transactionDate.setText(transactionModel.getTransactionDate().toString());
        transactionStatus.setText(transactionModel.getStatusName());
        if (transactionModel.getStatusName().equalsIgnoreCase("Failed")) //check the status value for the appropriate color
            transactionStatus.setTextColor(Color.parseColor("#ffcc0000")); //red
        else
            transactionStatus.setTextColor(Color.parseColor("#ff669900")); //green

        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is just optional.
                Toast.makeText(getContext(), "Transaction clicked is : " + transactionModel.getTransactionTypeName()+" Amount is :"+transactionModel.getAmount(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;
    }

}
