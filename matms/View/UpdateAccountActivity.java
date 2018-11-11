package com.awale.matms.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awale.matms.Controller.UpdateAccountController;
import com.awale.matms.Model.Users;
import com.awale.matms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class UpdateAccountActivity extends AppCompatActivity {

    public EditText editTextName;
    public EditText editTextEmail;
    public EditText editTextAmount;
    public EditText editTextMobile;
    public EditText editTextPassword;
    public Button buttonUpdate;
    FirebaseAuth mAuth;
    DatabaseReference mdatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mdatabaseReference = FirebaseDatabase.getInstance().getReference("accounts");
        UpdateAccountController updateAccountController = new UpdateAccountController();

        editTextName = (EditText) findViewById(R.id.editTextUserName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        findViewById(R.id.buttonUpdate).setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                UpdateAccountController controller=new UpdateAccountController();
                controller.updateaccount();
                break;
        }
    }
}


