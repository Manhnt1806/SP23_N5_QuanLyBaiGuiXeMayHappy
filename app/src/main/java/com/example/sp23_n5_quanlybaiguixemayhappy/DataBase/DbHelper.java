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
        String sql = "CREATE TABLE tb_khachHang(idKH INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, cccdKH TEXT NOT NULL UNIQUE, sdtKH TEXT NOT NULL UNIQUE, passKH TEXT NOT NULL, tenKH TEXT NOT NULL, soDuKH INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_khachHang VALUES(null, '034203008190', '0868983658','Manhnt1806', 'Mạnh', '1000000')";
        db.execSQL(sql);
        sql = "CREATE TABLE tb_napTien(idNT INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idKH INTEGER REFERENCES tb_khachHang(idKH), htttNT INTEGER NOT NULL, soTienNap INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_napTien VALUES(null, 1, 0, '100000')";
        db.execSQL(sql);
        sql = "CREATE TABLE tb_xe(idXe INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, idKH INTEGER REFERENCES tb_khachHang(idKH), bienSoXe TEXT NOT NULL UNIQUE, dangKyXe BYTE)";
        db.execSQL(sql);
        sql = "INSERT INTO tb_napTien VALUES(null, 1, 0, '100000')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
