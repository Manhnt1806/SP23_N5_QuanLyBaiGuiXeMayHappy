package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class Xe {
    private int idXe;
    private String bienSoXe;
    private String dangKyXe;
    private int statusXe;

    public Xe(int idXe, String bienSoXe, String dangKyXe, int statusXe) {
        this.idXe = idXe;
        this.bienSoXe = bienSoXe;
        this.dangKyXe = dangKyXe;
        this.statusXe = statusXe;
    }

    public int getIdXe() {
        return idXe;
    }

    public void setIdXe(int idXe) {
        this.idXe = idXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getDangKyXe() {
        return dangKyXe;
    }

    public void setDangKyXe(String dangKyXe) {
        this.dangKyXe = dangKyXe;
    }

    public int getStatusXe() {
        return statusXe;
    }

    public void setStatusXe(int statusXe) {
        this.statusXe = statusXe;
    }
}
