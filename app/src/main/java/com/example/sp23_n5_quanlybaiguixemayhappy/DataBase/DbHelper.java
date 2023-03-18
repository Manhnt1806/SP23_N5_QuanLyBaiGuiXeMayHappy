package com.example.sp23_n5_quanlybaiguixemayhappy.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "Happy_Lib";
    static final int DB_VERSION = 1;
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tb_khachHang(idKH INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, cccdKH TEXT NOT NULL UNIQUE, sdtKH TEXT NOT NULL UNIQUE, passKH TEXT NOT NULL, tenKH TEXT NOT NULL, soDuKH INTEGER NOT NULL, goiSD INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_khachHang VALUES(null, '034203008190', '0868983658','Manhnt1806', 'Nguyễn Thế Mạnh', '1000000', 1)";
        db.execSQL(sql);
        sql = "CREATE TABLE tb_nhanVien(idNV INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, chucVu TEXT NOT NULL, sdtNV TEXT NOT NULL UNIQUE, passNV TEXT NOT NULL, tenNV TEXT NOT NULL, statusNV INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_nhanVien VALUES(null, 'Quản lý', '0388844375','Manhnt1806', 'Mạnh NT', 1)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_nhanVien VALUES(null, 'Nhân viên', '0868973658','Nguyettt', 'Nguyệt TT', 1)";
        db.execSQL(sql);
        sql = "CREATE TABLE tb_baiGuiXe(idBaiGuiXe INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, soLuongGui INTEGER NOT NULL, soLuongTrong INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_baiGuiXe VALUES(null, 5, 4)";
        db.execSQL(sql);
        sql = "CREATE TABLE tb_napTien(idNT INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idKH INTEGER REFERENCES tb_khachHang(idKH), htttNT INTEGER NOT NULL, soTienNap INTEGER NOT NULL, statusNT INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_napTien VALUES(null, 1, 0, '100000', 1)";
        db.execSQL(sql);


        sql = "CREATE TABLE tb_xe(idXe INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idKH INTEGER REFERENCES tb_khachHang(idKH), bienSoXe TEXT NOT NULL UNIQUE, dangKyXe IMAGE, statusXe NOT NULL)";
        db.execSQL(sql);

        sql = "CREATE TABLE tb_guiXe(idGuiXe INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idXe INTEGER REFERENCES tb_xe(idXe), idBaiGuiXe INTEGER REFERENCES tb_baiGuiXe(idBaiGuiXe)," +
                "idNV INTEGER REFERENCES tb_nhanVien(idNV), tgVao DATE NOT NULL, tgRa DATE NOT NULL, haVao IMAGE NOT NULL, haRa IMAGE NOT NULL, statusGuiXe INTEGER NOT NULL)";
        db.execSQL(sql);

        sql = "CREATE TABLE hoaDon(idHD INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idGuiXe INTEGER REFERENCES tb_guiXe(idGuiXe), htTT INTEGER NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
