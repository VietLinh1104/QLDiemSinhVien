package com.ht22.QLDiemSinhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lop")
public class Lop {
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    @Id
    private String maLop;
    private String tenLop;
    private String maKhoa;
    private int soSV;

    public Lop(String tenLop, String maLop, String maKhoa, int soSV) {
        this.tenLop = tenLop;
        this.maLop = maLop;
        this.maKhoa = maKhoa;
        this.soSV = soSV;
    }


}
