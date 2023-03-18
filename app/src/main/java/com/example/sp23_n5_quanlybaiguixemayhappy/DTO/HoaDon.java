package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class HoaDon {
    private int idHD;
    private int htTT;

    public HoaDon(int idHD, int htTT) {
        this.idHD = idHD;
        this.htTT = htTT;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getHtTT() {
        return htTT;
    }

    public void setHtTT(int htTT) {
        this.htTT = htTT;
    }
}
