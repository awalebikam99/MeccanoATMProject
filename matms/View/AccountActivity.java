package com.awale.matms.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.awale.matms.Model.Users;
import com.awale.matms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
     ListView listViewAccount;
     List<Users> usersList;
     String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        listViewAccount = (ListView)findViewById(R.id.listview);

       // usersList=new ArrayList<>();
        FirebaseUser currentuser= FirebaseAuth.getInstance().getCurrentUser();
        userID= currentuser.getUid();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab:
                        finish();
                        startActivity(new Intent(AccountActivity.this, UpdateAccountActivity.class));
                }
            }
        });
        mDatabaseReference=FirebaseDatabase.getInstance().getReference();
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



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
