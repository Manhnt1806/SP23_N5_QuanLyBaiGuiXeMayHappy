package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class GuiXe {
    private int idGuiXe;
    private int thoiGianVao;
    private int thoiGianRa;
    private String haRa;
    private String haVao;
    private int statusGuiXe;

    public GuiXe(int idGuiXe, int thoiGianVao, int thoiGianRa, String haRa, String haVao, int statusGuiXe) {
        this.idGuiXe = idGuiXe;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
        this.haRa = haRa;
        this.haVao = haVao;
        this.statusGuiXe = statusGuiXe;
    }

    public int getIdGuiXe() {
        return idGuiXe;
    }

    public void setIdGuiXe(int idGuiXe) {
        this.idGuiXe = idGuiXe;
    }

    public int getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(int thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public int getThoiGianRa() {
        return thoiGianRa;
    }

    public void setThoiGianRa(int thoiGianRa) {
        this.thoiGianRa = thoiGianRa;
    }

    public String getHaRa() {
        return haRa;
    }

    public void setHaRa(String haRa) {
        this.haRa = haRa;
    }

    public String getHaVao() {
        return haVao;
    }

    public void setHaVao(String haVao) {
        this.haVao = haVao;
    }

    public int getStatusGuiXe() {
        return statusGuiXe;
    }

    public void setStatusGuiXe(int statusGuiXe) {
        this.statusGuiXe = statusGuiXe;
    }
}
