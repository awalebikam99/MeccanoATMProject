package com.awale.matms.Controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.awale.matms.R;
import com.awale.matms.View.DashboardActivity;
import com.awale.matms.View.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class LoginController extends LoginActivity {

    String pincode;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    public void userLogin() {
        LoginActivity loginActivity=new LoginActivity();

        pincode=loginActivity.editText_pincode.getText().toString().trim();

        if (pincode.isEmpty()) {
            Log.d(TAG, "signInWithCustomToken:fail");

            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithCustomToken(pincode)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCustomToken:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());

                        }
                    }
                });

    }
}

