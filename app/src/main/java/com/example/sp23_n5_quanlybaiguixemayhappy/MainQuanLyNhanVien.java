package com.example.sp23_n5_quanlybaiguixemayhappy;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.sp23_n5_quanlybaiguixemayhappy.Adapter.NhanVienAdapter;
import com.example.sp23_n5_quanlybaiguixemayhappy.DAO.NhanVienDAO;
import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.NhanVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

// Fragment quản lý nhân viên ở file Layout frag_quanlynhanvien
public class MainQuanLyNhanVien extends Fragment {


    FloatingActionButton fab;
    NhanVienDAO dao;
    ListView listViewQlNV;
    List<NhanVien> list;
    NhanVien nhanVien;
    NhanVienAdapter nhanVienAdapter;
    int a;
    int temp=0;

    EditText txtIdNv, txtchucvuNv, txttenNv , txtpassNv , txtsdtNv , txtstatusNv;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_quanlynhanvien, container, false);

        fab = view.findViewById(R.id.qlnhanvien_fab);
        listViewQlNV = view.findViewById(R.id.qlnhanvien_listview);

        loadTable();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=-1;
                openDialog(Gravity.CENTER);
            }
        });

        listViewQlNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                a = i;
                openDialog(Gravity.CENTER);
            }
        });

        return view;
    }

    private void loadTable(){
        dao = new NhanVienDAO(getActivity());
        list = dao.getAll();
        nhanVienAdapter = new NhanVienAdapter(getActivity(),R.layout.item_listview_qlnhanvien,list);
        listViewQlNV.setAdapter(nhanVienAdapter);
    }


    private void openDialog(int gravity){

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.frag_nhanvien);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }

        TextView tvTile = (TextView) dialog.findViewById(R.id.item_tvtile);

        txtIdNv = dialog.findViewById(R.id.edt_idnv);
        txtchucvuNv = dialog.findViewById(R.id.edt_phanloainv);
        txtpassNv = dialog.findViewById(R.id.pass_nhanvien);
        txtsdtNv = dialog.findViewById(R.id.edt_sdt_nv);
        txttenNv = dialog.findViewById(R.id.edt_hotennv);
        txtstatusNv = dialog.findViewById(R.id.edt_status_nv);

        Button btnadd = dialog.findViewById(R.id.btn_themnv);
        Button btncancel = dialog.findViewById(R.id.btn_huynv);

        dao = new NhanVienDAO(getActivity());
        txtpassNv.setInputType(InputType.TYPE_CLASS_NUMBER);

        if (a==-1){
            tvTile.setText("Thêm thành viên");

            txtIdNv.setEnabled(false);

            if (list.size()==0){
                txtIdNv.setText("1");
            }else {
                nhanVien = dao.getAll().get(list.size() - 1);
                txtIdNv.setText(String.valueOf(nhanVien.getIdNV() + 1));
            }

            btnadd.setOnClickListener(new View.OnClickListener() {
                NhanVien nhanVien = new NhanVien();
                @Override
                public void onClick(View view) {
                    validate();
                    if (temp==0){
                        nhanVien.setTenNV( txttenNv.getText().toString());
                        nhanVien.setSdtNV( txtsdtNv.getText().toString());
                        nhanVien.setStatusNV( Integer.parseInt(txtstatusNv.getText().toString()));
                        nhanVien.setPassNV( txtpassNv.getText().toString());
                        nhanVien.setChucVu( txtchucvuNv.getText().toString());
                        if (dao.Insert(nhanVien)>0){
                            Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            loadTable();
                        }else{
                            Toast.makeText(getActivity(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        temp=0;
                    }

                }
            });
            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Huỷ thêm", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
        }else{
            tvTile.setText("Sửa/Xóa Nhân viên");


            btnadd.setText("Sửa");
            btncancel.setText("Xoá");

            nhanVien = dao.getAll().get(a);

            txtIdNv.setText(String.valueOf(nhanVien.getIdNV()));
            txttenNv.setText(nhanVien.getTenNV());
            txtpassNv.setText(nhanVien.getPassNV());
            txtsdtNv.setText(nhanVien.getSdtNV());
            txtchucvuNv.setText(nhanVien.getChucVu());
            txtstatusNv.setText(String.valueOf(nhanVien.getStatusNV()));


            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate();
                    if (temp==0){
                        nhanVien = new NhanVien();
                        nhanVien.setIdNV( Integer.parseInt(txtIdNv.getText().toString()));
                        nhanVien.setTenNV( txttenNv.getText().toString());
                        nhanVien.setSdtNV( txtsdtNv.getText().toString());
                        nhanVien.setStatusNV( Integer.parseInt(txtstatusNv.getText().toString()));
                        nhanVien.setPassNV( txtpassNv.getText().toString());
                        nhanVien.setChucVu( txtchucvuNv.getText().toString());
                        if (dao.update(nhanVien)<0){
                            Toast.makeText(getActivity(), "Sửa thất bại", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            loadTable();
                        }
                    }else {
                        temp=0;
                    }
                }
            });
            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (temp==0){
                        if (dao.delete(String.valueOf(nhanVien.getIdNV()))<0){
                            Toast.makeText(getActivity(), "Xoá thất bại", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            loadTable();
                        }
                    }
                }
            });
        }
        dialog.show();
    }

    private void validate(){
        if(txtIdNv.length()==0){
            txtIdNv.setError("Vui lòng nhập id nhân viên !");
        }
        if (txtsdtNv.length() < 10 || txtsdtNv.length() > 10 || txtsdtNv.getText().charAt(0) != 0){
            txtsdtNv.setError("Số điện thoại sai định dạng !");
        }
        if(txtpassNv.length()==0){
            txtpassNv.setError("Vui lòng nhập Mật khẩu !");
        }else if (txtpassNv.length() <6){
            txtpassNv.setError("Mật khẩu quá ngắn !");
        }
        if(txttenNv.length()==0){
            txttenNv.setError("Vui lòng nhập tên nhân viên !");
        }
        if(txtchucvuNv.length()==0){
            txtchucvuNv.setError("Vui lòng nhập chức vụ nhân viên!");
        }
        if(txtstatusNv.length()==0){
            txtstatusNv.setError("Vui lòng nhập trạng thái nhân viên !");
        }if(txtsdtNv.length()==0){
            txtIdNv.setError("Vui lòng nhập Số điện thoại !");
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
