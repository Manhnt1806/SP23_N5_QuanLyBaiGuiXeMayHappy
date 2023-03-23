package com.example.sp23_n5_quanlybaiguixemayhappy.DangNhap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sp23_n5_quanlybaiguixemayhappy.MainChinh;
import com.example.sp23_n5_quanlybaiguixemayhappy.R;

public class DangNhap extends AppCompatActivity {
    EditText edName, edPass;
    Button btn_Login, btn_Cancle;
    CheckBox checkBox;
    String strName, strpass;
    Button_LoginDAO button_loginDAO;
    Buton_Login buton_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);


        setTitle("ĐĂNG NHẬP");
    edName = findViewById(R.id.txtName);
    edPass = findViewById(R.id.txtPass);
    btn_Login = findViewById(R.id.btn_Login);
    btn_Cancle = findViewById(R.id.btn_Cancle);
    checkBox = findViewById(R.id.chkRemember);
//         dao = new ThuThuDAO(this);

    //đăng nhập mật khẩu trc đó r mà lưu r
    SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
    String user = pref.getString("USERNAME","");
    String pass = pref.getString("PASSWORD","");
    Boolean rem = pref.getBoolean("REMEMBER",false);

        edName.setText(user);
        edPass.setText(pass);
        checkBox.setChecked(rem);

        btn_Cancle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            edName.setText("");
            edPass.setText("");
        }
    });
        btn_Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkLogin();
//                Intent intent = new Intent(LoginActiviti.this, MainActivity.class);
//               startActivity(intent);

        }
    });

}
    public  void rememberUser(String u , String p, boolean status){

        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        if(!status){
            edit.clear();
        }else{
            edit.putString("USERNAME",u);
            edit.putString("PASSWORD",p);
            edit.putBoolean("REMEMBER",status);
        }
        edit.commit();
    }
    public void checkLogin(){
        strName = edName.getText().toString();
        strpass = edPass.getText().toString();
        if(strName.isEmpty()||strpass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
        }else {
            if(edName.getText().toString().equals("admin") && edPass.getText().toString().equals("admin")){
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                rememberUser(strName, strpass, checkBox.isChecked());
                Intent i = new Intent(getApplicationContext(), MainChinh.class);
                i.putExtra("user" ,strName);
                startActivity(i);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
            }
}}}