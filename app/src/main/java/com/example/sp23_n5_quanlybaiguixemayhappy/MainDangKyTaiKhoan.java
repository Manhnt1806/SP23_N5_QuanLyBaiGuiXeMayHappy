package com.example.sp23_n5_quanlybaiguixemayhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sp23_n5_quanlybaiguixemayhappy.DAO.KhackHangDAO;
import com.example.sp23_n5_quanlybaiguixemayhappy.DAO.NhanVienDAO;
import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.KhachHang;
import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.NhanVien;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainDangKyTaiKhoan extends AppCompatActivity {

    NhanVienDAO nhanVienDAO;
    KhackHangDAO khackHangDAO;
    TextInputEditText edUsername , edPassword , edPasswordNhapLai;
    TextInputLayout tilpass,tiluser, tilpassNL;
    Button btnAddTk , btnExitTk;
    String StrUser , StrPass , StrPassNL;
    Spinner spnDangkytk;
    private List<String> list;

    String loaidk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangky);

        AnhXa();
        nhanVienDAO = new NhanVienDAO(this);
        khackHangDAO = new KhackHangDAO(this);

        list = new ArrayList<>();
        list.add("Người quản lý");
        list.add("Nhân viên");
        list.add("Khách hàng");

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);

        spnDangkytk.setAdapter(spinnerAdapter);
        spnDangkytk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                loaidk = list.get(position);
                Toast.makeText(getApplicationContext(), loaidk, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAddTk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrUser = edUsername.getText().toString().trim();
                StrPass = edPassword.getText().toString().trim();
                StrPassNL = edPasswordNhapLai.getText().toString().trim();
                NhanVien nhanVien  = new NhanVien();
                KhachHang khachHang = new KhachHang();
                Validate();
                if( loaidk.equals("Người quản lý") || loaidk.equals("Nhân viên")){
                    if(StrPass.equals(StrPassNL)){
                        if(nhanVienDAO.CheckUsernameNV(StrUser) > 0 || khackHangDAO.CheckUsernameKH(StrUser) > 0){
                            nhanVien.setSdtNV(StrUser);
                            nhanVien.setPassNV(StrPass);

                            nhanVien.setChucVu("");
                            nhanVien.setTenNV("");
                            nhanVien.setStatusNV(0);
                            if (nhanVienDAO.Insert(nhanVien) > 0) {
                                Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                edUsername.setText("");
                                edPassword.setText("");
                                edPasswordNhapLai.setText("");
                            }else {
                                Toast.makeText(getApplicationContext(), "Đăng ký thất bại !", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            tiluser.setError("Số điện thoại đã tồn tại !");
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Mât khẩu nhập lại không trùng với Mật khẩu !", Toast.LENGTH_SHORT).show();
                    }
                }else if(loaidk.equals("Khách hàng")){
                    if(StrPass.equals(StrPassNL)){
                        if(nhanVienDAO.CheckUsernameNV(StrUser) > 0 || khackHangDAO.CheckUsernameKH(StrUser) > 0){
                            khachHang.setSdtKH(StrUser);
                            khachHang.setPassKH(StrPass);

                            khachHang.setTenKH("");
                            khachHang.setCccdKH(0);
                            khachHang.setGoiSD(0);
                            khachHang.setSoDuKH(0);
                            if (khackHangDAO.Insert(khachHang) > 0) {
                                Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                edUsername.setText("");
                                edPassword.setText("");
                                edPasswordNhapLai.setText("");
                            }else {
                                Toast.makeText(getApplicationContext(), "Đăng ký thất bại !", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            tiluser.setError("Số điện thoại đã tồn tại !");
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Mât khẩu nhập lại không trùng với Mật khẩu !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnExitTk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainDangKyTaiKhoan.this, MainLogin.class);
                startActivity(intent);
            }
        });


    }

    private void AnhXa(){
        edUsername = findViewById(R.id.ed_edt_username);
        edPassword = findViewById(R.id.ed_edt_password);
        edPasswordNhapLai = findViewById(R.id.ed_edt_password2);
        btnAddTk = findViewById(R.id.btn_add_edit_TV);
        btnExitTk = findViewById(R.id.btn_exit_add_edit_TV);
        tiluser = findViewById(R.id.input_edt_username);
        tilpass = findViewById(R.id.input_edit_password);
        tilpassNL = findViewById(R.id.input_edit_password_2);
        spnDangkytk = (Spinner) findViewById(R.id.spn_dangkytk);
    }
    private void Validate(){
        if(StrUser.length()==0){
            tiluser.setError("Vui lòng nhập Số điện thoại !");
        }else{
            tiluser.setError("");
        }
        if (StrUser.length() < 10 || StrUser.length() > 10){
            tiluser.setError("Số điện thoại sai định dạng !");
        }
        if(StrPass.length()==0){
            tilpass.setError("Vui lòng nhập Mật khẩu !");
        }else if (StrPass.length() <6){
            tilpass.setError("Mật khẩu quá ngắn !");
        }else {
            tilpass.setError("");
        }
        if(StrPassNL.length()==0){
            tilpassNL.setError("Vui lòng nhập Mật khẩu xác nhận !");
        }else{
            tilpassNL.setError("");
        }
    }
}
