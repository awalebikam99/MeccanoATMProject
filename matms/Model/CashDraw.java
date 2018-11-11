package com.awale.matms.Model;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class CashDraw {
    int newbalance=0;
    Users users=new Users();
    int database_amount=Integer.parseInt(users.getAmount());
    public void cashwithdrawcalc(int amount){

        if(amount>10000){
            Log.w(TAG, "withdraw limit exceeded:failure");
        }

        else if (amount<database_amount){

            Log.w(TAG, "withdraw limit exceeded:failure");
        }else {
            newbalance = database_amount=amount;

        }
    }

    }
