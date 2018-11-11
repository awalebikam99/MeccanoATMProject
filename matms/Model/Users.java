package com.awale.matms.Model;

import com.awale.matms.View.AccountActivity;

import java.util.List;

public class Users {
    String userId;
    String accountname;
    String accountno;
    String email;
    String phone;
    String pincode;
    String amount;

    public Users() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Users(String userId, String accountname, String email, String phone, String amount,String pincode) {
        this.userId = userId;
        this.accountname = accountname;
        this.email = email;
        this.phone = phone;
        this.amount = amount;
        this.pincode = pincode;

    }
}
