package com.ht22.QLDiemSinhVien.entity;

public class Subject {
    private String maHocPhan;
    private String maKhoa;
    private String tenHocPhan;
    private int soTinChi;
    private String ghiChu;

    public Subject() {
    }

    public Subject(String maHocPhan, String maKhoa, String tenHocPhan, int soTinChi, String ghiChu) {
        this.maHocPhan = maHocPhan;
        this.maKhoa = maKhoa;
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.ghiChu = ghiChu;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
