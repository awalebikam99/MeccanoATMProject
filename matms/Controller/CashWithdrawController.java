package com.awale.matms.Controller;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.awale.matms.Model.CashDraw;
import com.awale.matms.Model.Users;
import com.awale.matms.R;
import com.awale.matms.View.AccountActivity;
import com.awale.matms.View.CashWithDrawActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CashWithdrawController extends CashWithDrawActivity {

    int database_amount;
    int new_amount = 0;
    DatabaseReference mDatabaseReference;
    FirebaseDatabase firebaseDatabase;
    Users user = new Users();
    CashWithDrawActivity cashWithDrawActivity=new CashWithDrawActivity();
    int user_amount=cashWithDrawActivity.editText_cash_input;
    public void cashWithDraw(int user_amount) {

        CashWithDrawActivity drawActivity= new CashWithDrawActivity();
        int database_amount=Integer.parseInt(user.getAmount());

        user_amount = Integer.parseInt(findViewById(R.id.edit_cash_input).toString());
        FirebaseUser currentuser= FirebaseAuth.getInstance().getCurrentUser();
        String userID= currentuser.getUid();
        mDatabaseReference=firebaseDatabase.getReference().child("accounts");
        CashDraw cashDraw=new CashDraw();
        cashDraw.cashwithdrawcalc(user_amount);
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                CashDraw cashDraw=new CashDraw();
                cashDraw.cashwithdrawcalc(user_amount);
               showData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         return ;
    }


    private int showData(@NonNull DataSnapshot dataSnapshot) {


        for (DataSnapshot profileSnapshop : dataSnapshot.getChildren()) {
            FirebaseUser currentuser= FirebaseAuth.getInstance().getCurrentUser();
            String userID= currentuser.getUid();
            Users users = new Users();

            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                int database_amount = (int) dataSnapshot.child("amount").getValue();
                new_amount = database_amount - user_amount;

                Toast.makeText(getApplicationContext(), "Your balance now is  " + new_amount, Toast.LENGTH_SHORT).show();

            }


        }
        return new_amount;
           }
    }




