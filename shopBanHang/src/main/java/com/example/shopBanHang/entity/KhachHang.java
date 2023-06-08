package com.example.shopBanHang.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khachhang_id")
    private Long id;
    @Column
    private String hoten;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String sodienthoai;
    @Column
    private String diachi;
    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DonHang> donHangs;
    public KhachHang() {
    }

    public KhachHang(Long id, String hoten, String email, String password, String sodienthoai, String diachi, Set<DonHang> donHangs) {
        this.id = id;
        this.hoten = hoten;
        this.email = email;
        this.password = password;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.donHangs = donHangs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Set<DonHang> getDonHangs() {
        return donHangs;
    }

    public void setDonHangs(Set<DonHang> donHangs) {
        this.donHangs = donHangs;
    }
}
