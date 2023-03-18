package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class NapTien {
    private int idNT;
    private String htttNT;
    private int soTien;
    private int statusNT;

    public NapTien(int idNT, String htttNT, int soTien, int statusNT) {
        this.idNT = idNT;
        this.htttNT = htttNT;
        this.soTien = soTien;
        this.statusNT = statusNT;
    }

    public int getIdNT() {
        return idNT;
    }

    public void setIdNT(int idNT) {
        this.idNT = idNT;
    }

    public String getHtttNT() {
        return htttNT;
    }

    public void setHtttNT(String htttNT) {
        this.htttNT = htttNT;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getStatusNT() {
        return statusNT;
    }

    public void setStatusNT(int statusNT) {
        this.statusNT = statusNT;
    }
}
