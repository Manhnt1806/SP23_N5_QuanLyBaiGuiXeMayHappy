package com.example.sp23_n5_quanlybaiguixemayhappy.DoiMatKhau;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.sp23_n5_quanlybaiguixemayhappy.R;


public class TaiKhoanFragment extends Fragment {
    Button btndoiMk, btnDangXuat, btnHotro;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tai_khoan, container, false);

        btndoiMk=view.findViewById(R.id.edtpass);
        btnDangXuat=view.findViewById(R.id.edtpassre1);
        btnHotro=view.findViewById(R.id.edtpassre2);

        btndoiMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new MatKhau()).commit();

            }
        });
        return view;

    }
}