package com.awale.matms.Controller;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.awale.matms.Model.Users;
import com.awale.matms.View.AccountActivity;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class DisplayAccountController{

    private void showData(@NonNull DataSnapshot dataSnapshot) {

        for(DataSnapshot profileSnapshop: dataSnapshot.getChildren()){
            Users users= new Users();
            users.setAccountname(profileSnapshop.child(userID).getValue(Users.class).getAccountname());
            users.setEmail(profileSnapshop.child(userID).getValue(Users.class).getEmail());
            users.setPhone(profileSnapshop.child(userID).getValue(Users.class).getPhone());
            users.setAmount(profileSnapshop.child(userID).getValue(Users.class).getAmount());

            ArrayList<String> arrayList=new ArrayList<>();
            arrayList.add(users.getAccountname());
            arrayList.add(users.getEmail());
            arrayList.add(users.getPhone());
            arrayList.add(users.getAmount());
            ArrayAdapter arrayAdapter;
            arrayAdapter = new ArrayAdapter(AccountActivity.this,android.R.layout.simple_list_item_1,arrayList);
            listViewAccount.setAdapter(arrayAdapter);


        }
    }
}
