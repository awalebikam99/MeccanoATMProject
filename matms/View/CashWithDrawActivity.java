package com.awale.matms.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.awale.matms.Controller.CashWithdrawController;
import com.awale.matms.R;

public class CashWithDrawActivity extends AppCompatActivity {

    EditText editText_cash_input;
    Button button_withdraw;
    int cash_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_with_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText_cash_input= (EditText)findViewById(R.id.edit_cash_input);
        Button button_withdraw = (Button) findViewById(R.id.btn_withDraw);
        button_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CashWithdrawController cashdraw= new CashWithdrawController();
                cash_input=Integer.parseInt(editText_cash_input.getText().toString());
                  cashdraw.cashWithDraw(cash_input);
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
  }


}
