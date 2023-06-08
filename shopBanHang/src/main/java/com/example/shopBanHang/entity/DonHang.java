package com.example.shopBanHang.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonHang_id")
    private Long id;
    @Column
    private String ngayDatHang;
    @Column
    private String diaChiGiao;
    @ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false, referencedColumnName = "khachhang_id")
    @JsonBackReference
    private KhachHang khachHang;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<SanPham> sanPham;
    public DonHang() {
    }

    public DonHang(Long id, String ngayDatHang, String diaChiGiao, KhachHang khachHang, Set<SanPham> sanPham) {
        this.id = id;
        this.ngayDatHang = ngayDatHang;
        this.diaChiGiao = diaChiGiao;
        this.khachHang = khachHang;
        this.sanPham = sanPham;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getDiaChiGiao() {
        return diaChiGiao;
    }

    public void setDiaChiGiao(String diaChiGiao) {
        this.diaChiGiao = diaChiGiao;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Set<SanPham> getSanPham() {
        return sanPham;
    }

    public void setSanPham(Set<SanPham> sanPham) {
        this.sanPham = sanPham;
    }
}
