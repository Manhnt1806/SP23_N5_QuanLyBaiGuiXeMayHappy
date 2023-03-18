package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class KhachHang {
    private int id;
    private String tenKH;
    private String gioiTinh;
    private String diaChi;
    private int cccdKH;
    private int sdtKH;
    private String passKH;
    private int soDuKH;
    private int goiSD;

    public KhachHang(int id, String tenKH, String gioiTinh, String diaChi, int cccdKH, int sdtKH, String passKH, int soDuKH, int goiSD) {
        this.id = id;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.cccdKH = cccdKH;
        this.sdtKH = sdtKH;
        this.passKH = passKH;
        this.soDuKH = soDuKH;
        this.goiSD = goiSD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getCccdKH() {
        return cccdKH;
    }

    public void setCccdKH(int cccdKH) {
        this.cccdKH = cccdKH;
    }

    public int getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(int sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getPassKH() {
        return passKH;
    }

    public void setPassKH(String passKH) {
        this.passKH = passKH;
    }

    public int getSoDuKH() {
        return soDuKH;
    }

    public void setSoDuKH(int soDuKH) {
        this.soDuKH = soDuKH;
    }

    public int getGoiSD() {
        return goiSD;
    }

    public void setGoiSD(int goiSD) {
        this.goiSD = goiSD;
    }
}
