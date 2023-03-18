package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class BaiGuiXe {
    private int idBaiGuiXe;
    private int soLuongGui;
    private int soLuongTrong;

    public BaiGuiXe(int idBaiGuiXe, int soLuongGui, int soLuongTrong) {
        this.idBaiGuiXe = idBaiGuiXe;
        this.soLuongGui = soLuongGui;
        this.soLuongTrong = soLuongTrong;
    }

    public int getIdBaiGuiXe() {
        return idBaiGuiXe;
    }

    public void setIdBaiGuiXe(int idBaiGuiXe) {
        this.idBaiGuiXe = idBaiGuiXe;
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
