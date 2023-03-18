package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class KhachHang {
    private int idKH;
    private int cccdKH;
    private int sdtKH;
    private String passKH;
    private String tenKH;
    private int soDuKH;
    private int goiSD;
//    private String gioiTinh;
//    private String diaChi;


    public KhachHang(int idKH, int cccdKH, int sdtKH, String passKH, String tenKH, int soDuKH, int goiSD) {
        this.idKH = idKH;
        this.cccdKH = cccdKH;
        this.sdtKH = sdtKH;
        this.passKH = passKH;
        this.tenKH = tenKH;
        this.soDuKH = soDuKH;
        this.goiSD = goiSD;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
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

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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
