package com.example.shopBanHang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sp_id")
    private Long Id;
    @Column
    private String tenSanPham;
    @Column
     private double giaTien;
    @Column
     private int soLuong;
    @Column
     private String moTa;
    @ManyToOne
    @JoinColumn(name = "DonHang_id", nullable = false, referencedColumnName = "DonHang_id")
    @JsonBackReference
    private DonHang donHang;

    public SanPham() {
    }

    public SanPham(Long id, String tenSanPham, double giaTien, int soLuong, String moTa, DonHang donHang) {
        Id = id;
        this.tenSanPham = tenSanPham;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.donHang = donHang;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}
