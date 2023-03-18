package com.example.sp23_n5_quanlybaiguixemayhappy.DTO;

public class GuiXe {
    private int id;
    private int thoiGianVao;
    private int thoiGianRa;
    private int statusGuiXe;
    private String haRa;
    private String haVao;

    public GuiXe(int id, int thoiGianVao, int thoiGianRa, int statusGuiXe, String haRa, String haVao) {
        this.id = id;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
        this.statusGuiXe = statusGuiXe;
        this.haRa = haRa;
        this.haVao = haVao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatusGuiXe() {
        return statusGuiXe;
    }

    public void setStatusGuiXe(int statusGuiXe) {
        this.statusGuiXe = statusGuiXe;
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
}
