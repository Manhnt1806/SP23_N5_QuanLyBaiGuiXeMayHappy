package com.example.sp23_n5_quanlybaiguixemayhappy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainLogin extends AppCompatActivity {
    TextInputLayout edUsename, edPassword;
    Button btnLogin, btnExit;
    CheckBox luuMK;
    String strUser, strPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent =new Intent(MainLogin.this, MainChinh.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);


    }
}
