package com.example.sp23_n5_quanlybaiguixemayhappy.DoiMatKhau;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sp23_n5_quanlybaiguixemayhappy.DangNhap.Buton_Login;
import com.example.sp23_n5_quanlybaiguixemayhappy.DangNhap.Button_LoginDAO;
import com.example.sp23_n5_quanlybaiguixemayhappy.MainChinh;
import com.example.sp23_n5_quanlybaiguixemayhappy.R;

public class MatKhau extends Fragment {
    EditText edtuser,edtpass,edtpassre1,edtpassre2;
    Button btnHuy,btnMK;
    Button_LoginDAO loginDao;
    Buton_Login login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.matkhau,container,false);
        btnHuy=view.findViewById(R.id.btnHuy);
        btnMK=view.findViewById(R.id.btnMK);
        loginDao=new Button_LoginDAO(getContext());
        edtuser=view.findViewById(R.id.edtuser);
        edtpass=view.findViewById(R.id.edtpass);
        edtpassre1=view.findViewById(R.id.edtpassre1);
        edtpassre2=view.findViewById(R.id.edtpassre2);
        btnHuy=view.findViewById(R.id.btnHuy);
        btnMK=view.findViewById(R.id.btnMK);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Đổi mật khẩu không thành công", Toast.LENGTH_LONG).show();
                Intent i =new Intent(getContext(), MainChinh.class);
                startActivity(i);
            }
        });

        btnMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtuser.getText().toString();
                String pass = edtpassre1.getText().toString();
                if (edtuser.getText().length() != 0 && edtpass.getText().length() != 0 && edtpassre1.getText().length() != 0 && edtpassre2.getText().length() != 0) {
                    if (loginDao.searchTK(user) == true) {
                        if (loginDao.searchMK(user).equals(edtpass.getText().toString())) {
                            if(edtpassre1.getText().toString().equals(edtpassre2.getText().toString())) {
                                login=new Buton_Login(user,pass);
                                loginDao.update(login);
                                Toast.makeText(getContext(), "Đổi mật khẩu thành công", Toast.LENGTH_LONG).show();

                                Intent i =new Intent(getContext(), MainChinh.class);
                                startActivity(i);
                            }else {
                                Toast.makeText(getContext(), "Nhập mật khẩu mới không trùng", Toast.LENGTH_LONG).show();
                            }}else {
                            Toast.makeText(getContext(), "Nhập mật khẩu không đúng", Toast.LENGTH_LONG).show();
                        }}else {
                        Toast.makeText(getContext(), "Tài khoản không tồn tại", Toast.LENGTH_LONG).show();
                    }}else {
                    Toast.makeText(getContext(), "Chưa điền đủ thông tin", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
