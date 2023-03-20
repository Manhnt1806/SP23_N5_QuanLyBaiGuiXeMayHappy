package com.example.sp23_n5_quanlybaiguixemayhappy.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.NhanVien;
import com.example.sp23_n5_quanlybaiguixemayhappy.DataBase.DbHelper;

import java.util.List;

public class NhanVienDAO {
    private SQLiteDatabase sqLiteDatabase;

    public NhanVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public long Insert(NhanVien nhanVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenNV", nhanVien.getTenNV());
        contentValues.put("passNV", nhanVien.getPassNV());
        contentValues.put("chucVu", nhanVien.getChucVu());
        contentValues.put("sdtNV", nhanVien.getSdtNV());
        contentValues.put("statusNV", nhanVien.getStatusNV());
        return sqLiteDatabase.insert("tb_nhanVien", null, contentValues);
    }


    public int CheckUsernameNV(String sdtNV){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tb_nhanVien WHERE sdtNV=?", new String[]{sdtNV});
        if(cursor.getCount() > 0){
            return -1;
        }else{
            return 1;
        }
    }
}
