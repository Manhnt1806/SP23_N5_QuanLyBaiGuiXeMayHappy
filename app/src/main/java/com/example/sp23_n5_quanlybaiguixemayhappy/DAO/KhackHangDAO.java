package com.example.sp23_n5_quanlybaiguixemayhappy.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.KhachHang;
import com.example.sp23_n5_quanlybaiguixemayhappy.DataBase.DbHelper;

public class KhackHangDAO {
    private SQLiteDatabase sqLiteDatabase;

    public KhackHangDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public long Insert(KhachHang khachHang){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenKH", khachHang.getTenKH());
        contentValues.put("cccdKH", khachHang.getCccdKH());
        contentValues.put("sdtKH", khachHang.getSdtKH());
        contentValues.put("passKH", khachHang.getPassKH());
        contentValues.put("soDuKH", khachHang.getSoDuKH());
        contentValues.put("goiSD", khachHang.getGoiSD());
        return sqLiteDatabase.insert("tb_khachHang", null, contentValues);
    }

    public int CheckUsernameKH(String sdtKH){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tb_khachHang WHERE sdtKH=?", new String[]{sdtKH});
        if(cursor.getCount() > 0){
            return -1;
        }else{
            return 1;
        }
    }
}
