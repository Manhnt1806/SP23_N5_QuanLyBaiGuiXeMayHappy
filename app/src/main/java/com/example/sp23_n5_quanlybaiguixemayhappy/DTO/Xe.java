package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class Xe {
    private int id;
    private String tenXe;
    private String bienSoXe;
    private String dangKyXe;
    private int statusXe;

    public Xe(int id, String tenXe, String bienSoXe, String dangKyXe, int statusXe) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.dangKyXe = dangKyXe;
        this.statusXe = statusXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
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
