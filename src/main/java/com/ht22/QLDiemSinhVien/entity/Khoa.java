package com.ht22.QLDiemSinhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    private String tenKhoa;
    private String maKhoa;


    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public Khoa(String tenKhoa, String maKhoa) {
        this.tenKhoa = tenKhoa;
        this.maKhoa = maKhoa;
    }

    public Khoa() {
    }

    @Override
    public String toString() {
        return tenKhoa;
    }
}
