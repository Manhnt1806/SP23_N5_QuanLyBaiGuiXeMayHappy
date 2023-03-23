package com.example.sp23_n5_quanlybaiguixemayhappy.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sp23_n5_quanlybaiguixemayhappy.DTO.NhanVien;
import com.example.sp23_n5_quanlybaiguixemayhappy.DataBase.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private SQLiteDatabase sqLiteDatabase;

    public NhanVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public long Insert(NhanVien nhanVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put("sdtNV", nhanVien.getSdtNV());
        contentValues.put("passNV", nhanVien.getPassNV());
        contentValues.put("tenNV", nhanVien.getTenNV());
        contentValues.put("chucVu", nhanVien.getChucVu());
        contentValues.put("statusNV", nhanVien.getStatusNV());
        return sqLiteDatabase.insert("tb_nhanVien", null, contentValues);
    }

    public long update(NhanVien nhanVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenNV", nhanVien.getTenNV());
        contentValues.put("passNV", nhanVien.getPassNV());
        contentValues.put("chucVu", nhanVien.getChucVu());
        contentValues.put("sdtNV", nhanVien.getSdtNV());
        contentValues.put("statusNV", nhanVien.getStatusNV());
        return sqLiteDatabase.update("tb_nhanVien",contentValues,"idNV=?",new String[]{String.valueOf(nhanVien.getIdNV())});
    }

    public int delete(String idNV){
        return sqLiteDatabase.delete("tb_nhanVien","idNV=?",new String[]{idNV});
    }

    public List<NhanVien> getAll(){
        String sql = "SELECT * FROM tb_nhanVien";
        return getData(sql);
    }
    public NhanVien getID(String idNV){
        String sql = "SELECT * FROM tb_nhanVien WHERE idNV=?";
        List<NhanVien> list = getData(sql,idNV);
        return list.get(0);
    }

    private List<NhanVien> getData(String sql, String...selectionArgs){
        List<NhanVien> list = new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            NhanVien nhanVien = new NhanVien();
            nhanVien.setIdNV(Integer.parseInt(c.getString(0)));
            nhanVien.setChucVu(c.getString(1));
            nhanVien.setSdtNV( c.getString(2));
            nhanVien.setPassNV( c.getString(3));
            nhanVien.setTenNV( c.getString(4));
            nhanVien.setStatusNV( Integer.parseInt(c.getString(5)));
            list.add(nhanVien);
        }
        return list;
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
