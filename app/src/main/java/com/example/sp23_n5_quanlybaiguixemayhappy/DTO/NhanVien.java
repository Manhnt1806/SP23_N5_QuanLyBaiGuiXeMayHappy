package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class NhanVien {
    private int id;
    private String phanLoaiNV;
    private String hoTenNV;
    private int sdtNV;
    private String user;
    private String pass;

    public NhanVien(int id, String phanLoaiNV, String hoTenNV, int sdtNV, String user, String pass) {
        this.id = id;
        this.phanLoaiNV = phanLoaiNV;
        this.hoTenNV = hoTenNV;
        this.sdtNV = sdtNV;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhanLoaiNV() {
        return phanLoaiNV;
    }

    public void setPhanLoaiNV(String phanLoaiNV) {
        this.phanLoaiNV = phanLoaiNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public int getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(int sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
