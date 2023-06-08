package com.example.shopBanHang.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamReqDTO {
    private String tenSanPham;
    private double giaTien;
    private int soLuong;
    private String moTa;
    private Long donHangId;


}
