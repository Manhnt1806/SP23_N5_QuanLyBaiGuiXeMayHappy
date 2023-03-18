package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class BaiGuiXe {
    private int id;
    private int soLuongGui;
    private int soLuongTrong;

    public BaiGuiXe(int id, int soLuongGui, int soLuongTrong) {
        this.id = id;
        this.soLuongGui = soLuongGui;
        this.soLuongTrong = soLuongTrong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuongGui() {
        return soLuongGui;
    }

    public void setSoLuongGui(int soLuongGui) {
        this.soLuongGui = soLuongGui;
    }

    public int getSoLuongTrong() {
        return soLuongTrong;
    }

    public void setSoLuongTrong(int soLuongTrong) {
        this.soLuongTrong = soLuongTrong;
    }
}
