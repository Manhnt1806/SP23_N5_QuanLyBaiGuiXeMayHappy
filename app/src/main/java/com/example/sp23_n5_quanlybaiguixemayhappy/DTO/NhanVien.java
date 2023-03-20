package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class NhanVien {
    private int idNV;
    private String chucVu;
    private String sdtNV;
    private String passNV;
    private String tenNV;
    private int statusNV;

    public NhanVien() {
    }

    public NhanVien(int idNV, String chucVu, String sdtNV, String passNV, String tenNV, int statusNV) {
        this.idNV = idNV;
        this.chucVu = chucVu;
        this.sdtNV = sdtNV;
        this.passNV = passNV;
        this.tenNV = tenNV;
        this.statusNV = statusNV;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getPassNV() {
        return passNV;
    }

    public void setPassNV(String passNV) {
        this.passNV = passNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getStatusNV() {
        return statusNV;
    }

    public void setStatusNV(int statusNV) {
        this.statusNV = statusNV;
    }
}
