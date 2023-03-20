package com.example.sp23_n5_quanlybaiguixemayhappy.DangNhap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sp23_n5_quanlybaiguixemayhappy.DataBase.DbHelper;

public class Button_LoginDAO {
    private SQLiteDatabase sqLiteDatabaseW;
    private SQLiteDatabase sqLiteDatabaseR;

    public Button_LoginDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqLiteDatabaseW=dbHelper.getWritableDatabase();
        sqLiteDatabaseR=dbHelper.getReadableDatabase();
    }

    public long update(Buton_Login s) {
        ContentValues values = new ContentValues();
        values.put("pass", s.pass);
        return sqLiteDatabaseW.update("Login", values, "user=?", new String[]{(s.user)});
    }

    public boolean searchTK(String user){
        String query="select user from Login";
        Cursor cursor=sqLiteDatabaseR.rawQuery(query,null);
        String User;
        if(cursor.moveToFirst()){
            do{
                User=cursor.getString(cursor.getColumnIndex("user"));
                if(User.equals(user)){
                    return true;
                }
            }while (cursor.moveToNext());
        }
        return false;
    }

    public String searchMK(String user){
        String query="select user,pass from Login";
        Cursor cursor=sqLiteDatabaseR.rawQuery(query,null);

        String User;
        String pass="not found";
        if(cursor.moveToFirst()){
            do{
                User=cursor.getString(cursor.getColumnIndex("user"));
                if(User.equals(user)){
                    pass=cursor.getString(cursor.getColumnIndex("pass"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        return pass;
    }
}
