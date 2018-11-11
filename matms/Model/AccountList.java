package com.awale.matms.Model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.awale.matms.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.List;

public class AccountList extends ArrayAdapter<Users> {

    private Activity context;
    private List<Users> accountList;

    public AccountList(Activity context, List<Users> accountList){
        super(context, R.layout.listholder,accountList);
        this.context=context;
        this.accountList=accountList;
    }

    @NotNull
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listholder,null, true);

        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textAccountName);
        TextView textViewAcNo=(TextView)listViewItem.findViewById(R.id.textAccountno);
        TextView textViewEmail=(TextView)listViewItem.findViewById(R.id.textEmail);
        TextView textViewPhone=(TextView)listViewItem.findViewById(R.id.textPhone);
        TextView textViewBalance=(TextView)listViewItem.findViewById(R.id.textBalance);

        Users users= accountList.get(position);

        textViewName.setText(users.getAccountname());
        textViewAcNo.setText(users.getAccountno());
        textViewEmail.setText(users.getEmail());
        textViewPhone.setText(users.getPhone());
        textViewBalance.setText(users.getAmount());

        return listViewItem;

    }

}


