package com.awale.matms.Controller;

import android.text.TextUtils;
import android.widget.Toast;
import com.awale.matms.Model.Users;
import com.awale.matms.View.UpdateAccountActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class UpdateAccountController extends UpdateAccountActivity{

DatabaseReference mdatabaseReference;
UpdateAccountActivity updateAccountActivity=new UpdateAccountActivity();

    public void updateaccount(){
        String name= updateAccountActivity.editTextName.getText().toString().trim();
        String email=updateAccountActivity.editTextEmail.getText().toString().trim();
        String mobile=updateAccountActivity.editTextMobile.getText().toString().trim();
        String amount= updateAccountActivity.editTextAmount.getText().toString().trim();
        String password=updateAccountActivity.editTextPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){
            FirebaseUser currentuser= FirebaseAuth.getInstance().getCurrentUser();
            String id= currentuser.getUid();
            Users user = new Users(id, name, email, mobile, amount, password);
            mdatabaseReference.child(id).setValue(user);

            Toast.makeText(this, "Information updated and stored",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "You should enter a valid name",Toast.LENGTH_LONG).show();
        }
    }
}
